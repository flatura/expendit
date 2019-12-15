package code.flatura.expendit.service;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.ConsumeFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumeFactService {

    @Autowired
    private ConsumeFactRepository consumeFactRepository;
    @Autowired
    private ConsumableRepository consumableRepository;

    public ConsumeFactService(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
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

    public void save(int id, ConsumeFact updatedConsumeFact) {
        if (consumeFactRepository.existsById(id)) {
            consumeFactRepository.save(updatedConsumeFact);
        }
    }

    public void delete(int id) {
        consumeFactRepository.deleteById(id);
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
}
