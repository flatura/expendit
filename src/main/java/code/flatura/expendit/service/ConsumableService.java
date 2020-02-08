package code.flatura.expendit.service;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.model.ConsumableStatus;
import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.ConsumeFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumableService {

    private ConsumableRepository consumableRepository;
    private ConsumeFactRepository consumeFactRepository;

    public ConsumableService(ConsumableRepository consumableRepository) {
        this.consumableRepository = consumableRepository;
    }

    public ConsumableService() {
    }

    @Autowired
    public void setConsumableRepository(ConsumableRepository consumableRepository) {
        this.consumableRepository = consumableRepository;
    }

    @Autowired
    public void setConsumeFactRepository(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
    }

    public Consumable create(Consumable newConsumable) {return consumableRepository.save(newConsumable);}

    public List<Consumable> getAll() {
        return consumableRepository.findAll();
    }

    public Optional<Consumable> getById(int id) {
        return consumableRepository.findById(id);
    }

    public void update(Consumable consumable, int id) {
        if (consumable.getId() == null || consumableRepository.existsById(id))
        {
            consumableRepository.save(consumable);
        }
    }

    public void delete(int id) {
        consumableRepository.deleteById(id);
    }

    @Transactional
    public void install(int consuambleId, int roomId) {
        Consumable newConsumable;
        Consumable oldConsumable;

        if ((newConsumable = consumableRepository.getOne(consuambleId)) != null) {
            // Меняем статус выбранного расходника с Новый на В работе и устанавливаем его в кабинет
            if (newConsumable.getStatus() == ConsumableStatus.NEW) {
                newConsumable.setStatus(ConsumableStatus.INWORK);
                newConsumable.setRoomId(roomId);
                // Забираем старый расходник этой же модели, установленный в указанном кабинете
                oldConsumable = consumableRepository.findByRoomId(roomId)
                        .stream()
                        .filter(c -> c.getConsumableModelId().equals(newConsumable.getConsumableModelId()))
                        .filter(c -> c.getStatus() == ConsumableStatus.INWORK)
                        .findFirst()
                        .orElseGet(null);
                if (oldConsumable != null) {
                    oldConsumable.setRoomId(newConsumable.getRoomId());
                    oldConsumable.setStatus(ConsumableStatus.EMPTY);
                    oldConsumable.setRoomId(newConsumable.getRoomId());
                    consumableRepository.save(oldConsumable);
                }
                consumableRepository.save(newConsumable);
                // Создать факт расхода
                consumeFactRepository.save(new ConsumeFact(
                        roomId,
                        newConsumable.getRoomId(),
                        newConsumable.getId(),
                        newConsumable.getConsumableModelId(),
                        LocalDate.now())
                );
            }
        }
    }

    // TODO Reduce complexity
    public List<Consumable> getBy(Integer roomId, Integer status, String name) {
        List<Consumable> result = new ArrayList<>();
        if (roomId != null && status != null) result = consumableRepository.findByRoomIdAndStatus(roomId, status);
        else if (roomId != null) result = consumableRepository.findByRoomId(roomId);
        else if (status != null) result = consumableRepository.findByStatus(status);
        if (name != null) {
            List<Consumable> listByName = consumableRepository.findByName("%" + name + "%");
            if (result.size() == 0) result = listByName;
            else result.retainAll(listByName);
        }
        return result;
    }
}
