package code.flatura.expendit.service;

import code.flatura.expendit.model.Consumable;
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
public class ConsumeFactService {

    private ConsumeFactRepository consumeFactRepository;
    private ConsumableRepository consumableRepository;

    @Autowired
    public ConsumeFactService(ConsumeFactRepository consumeFactRepository, ConsumableRepository consumableRepository) {
        this.consumeFactRepository = consumeFactRepository;
        this.consumableRepository = consumableRepository;
    }

    public ConsumeFactService() {
    }

    @Autowired
    public void setConsumeFactRepository(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
    }

    @Transactional
    public ConsumeFact create(ConsumeFact newConsumeFact) {
        // Картридж с указанным id и статусом Новый пометить, как В работе (изменить статус)
        consumableRepository.install(newConsumeFact.getConsumableId(), newConsumeFact.getRoomId());
        Consumable installedConsumable = consumableRepository.getOne(newConsumeFact.getConsumableId());
        newConsumeFact.setConsumableModelId(installedConsumable.getConsumableTypeId());
        // Добавить экземпляр ConsumeFact с информацией о модели картриджа, id-расходника, кабинета в таблицу БД
        return consumeFactRepository.save(newConsumeFact);
    }


    public List<ConsumeFact> getAll() {
        return consumeFactRepository.findAll();
    }


    public Optional<ConsumeFact> getById(int id) {
        return consumeFactRepository.findById(id);
    }

    public List<ConsumeFact> getByModelId(int id) {
        return consumeFactRepository.getByModelId(id);
    }

    public List<ConsumeFact> getByRoomId(int roomId) {
        return consumeFactRepository.getByRoomId(roomId);
    }

    public List<ConsumeFact> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        System.out.println("Getting ConsumeFact between " + startDate + " and " + endDate);
        return consumeFactRepository.getBetweenDates(startDate, endDate);
    }

    // Only allow deleting the mistakenly created ConsumeFact
    public void delete(int id) {
        // TODO get rid of .get() and process Optional correctly
        ConsumeFact fact = consumeFactRepository.findById(id).get();
        Consumable consumable = consumableRepository.findById(fact.getConsumableId()).get();
        // If status is IN_USE then set status NEW, return it to the storage and delete fact
        if (consumable.getStatus() == 2) {
            consumable.setStatus(1);
            consumable.setRoomId(fact.getStorage_id());
            consumeFactRepository.deleteById(id);
        }
    }

    public List<ConsumeFact> getBy(Integer roomId, Integer modelId) {
        List<ConsumeFact> result = new ArrayList<>();
        if (roomId != null && modelId != null ) result = consumeFactRepository.getByRoomIdAndModelid(roomId, modelId);
        else if (roomId != null) result = consumeFactRepository.getByRoomId(roomId);
        else if (modelId != null) result = consumeFactRepository.getByModelId(modelId);
        return result;
    }
}
