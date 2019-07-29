package code.flatura.expendit.service;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.ConsumeFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Consumable> getFull() {
        return consumableRepository.findFull();
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

    public void install(int consuambleId, int roomId) {
        Consumable newConsumable;
        Consumable oldConsumable;

        if ((newConsumable = consumableRepository.getOne(consuambleId)) != null) {

            // Забираем старый картридж этой же модели, установленный в указанном кабинете
            // TODO Учесть возможное наличие нескольких моделей потребителей в одном кабинете
            oldConsumable = consumableRepository.getByRoomId(roomId)
                    .stream()
                    .filter(c -> c.getConsumableModelId().equals(newConsumable.getConsumableModelId()))
                    .findFirst()
                    .orElseGet(null);
            if (oldConsumable != null) oldConsumable.setRoomId(newConsumable.getRoomId());

            // Меняем статус выбранного расходника с Новый на В работе и устанавливаем его в кабинет
            //TODO Сделать Status enum'ом
            if (newConsumable.getStatus() == 1) {
                newConsumable.setStatus(2);
                newConsumable.setRoomId(roomId);
            }

            // Создать факт расхода
            consumeFactRepository.save(new ConsumeFact(roomId, newConsumable.getId(), newConsumable.getConsumableModelId(), LocalDate.now()));
        }
    }

    public List<Consumable> getByRoomId(int roomId) {
        return consumableRepository.getByRoomId(roomId);
    }
}
