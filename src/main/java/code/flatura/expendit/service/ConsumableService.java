package code.flatura.expendit.service;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.model.ConsumableStatus;
import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.ConsumeFactRepository;
import code.flatura.expendit.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumableService {

    private ConsumableRepository consumableRepository;
    private ConsumeFactRepository consumeFactRepository;

    public ConsumableService() {
    }

    @Autowired
    public ConsumableService(ConsumableRepository consumableRepository, ConsumeFactRepository consumeFactRepository) {
        this.consumableRepository = consumableRepository;
        this.consumeFactRepository = consumeFactRepository;
    }

    public Consumable create(Consumable newConsumable) {
        return consumableRepository.save(newConsumable);
    }

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
    public void installOne(int consumableId, int roomId) {
        Consumable newConsumable;

        if ((consumableId != 0) && (newConsumable = consumableRepository.getOne(consumableId)) != null) {
            // Меняем статус выбранного расходника с Новый на В работе и устанавливаем его в кабинет
            if (newConsumable.getStatus() == ConsumableStatus.NEW) {
                newConsumable.setStatus(ConsumableStatus.EMPTY);
                newConsumable.setRoomId(roomId);
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

    @Transactional
    public List<Consumable> installMany(int consumableModelId, int count, int destinationRoom) {
        List<Consumable> installedConsumableList = new ArrayList<>();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                Optional<Consumable> activeConsumable = consumableRepository.findFirstByConsumableModelIdAndStatus(consumableModelId, ConsumableStatus.NEW);
                if (activeConsumable.isPresent()) {
                    activeConsumable.get().setRoomId(destinationRoom);
                    activeConsumable.get().setStatus(ConsumableStatus.INWORK);
                    consumeFactRepository.save(new ConsumeFact(
                                    destinationRoom,
                                    activeConsumable.get().getRoomId(),
                                    activeConsumable.get().getId(),
                                    activeConsumable.get().getConsumableModelId(),
                                    LocalDate.now()));
                    installedConsumableList.add(activeConsumable.get());
                    consumableRepository.save(activeConsumable.get());
                    // TODO Поиск и выставление статуса EMPTY у расходников из destinationRoom
                    consumableRepository.flush();
                    consumeFactRepository.flush();
                }
            }
        }
        return installedConsumableList;
/*
        //Проверяем, есть ли нужное количество на складах
        if (count <= statisticsRepository.getAmountOfConsumable(consumableModelId, ConsumableStatus.NEW).getCount()) {
        //Находим нужное число FULL
            List<Consumable> consumableList = consumableRepository.findByModelIdWithLimit(consumableModelId, count);
            for (Consumable c : consumableList) {
                //Создаем факт расхода
                consumeFactRepository.save(new ConsumeFact(
                        roomId,
                        c.getRoomId(),
                        c.getId(),
                        c.getConsumableModelId(),
                        LocalDate.now())
                );
                //Для каждого ставим EMPTY + меняем кабинет
                c.setStatus(ConsumableStatus.EMPTY);
                //Меняем комнату
                c.setRoomId(roomId);

            }
            consumableRepository.flush();
            consumeFactRepository.flush();
*/
            //Сохранем в БД
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
