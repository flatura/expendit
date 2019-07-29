package code.flatura.expendit.service;

import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.repository.ConsumeFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumeFactService {

    private ConsumeFactRepository consumeFactRepository;

    public ConsumeFactService(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
    }

    public ConsumeFactService() {
    }

    @Autowired
    public void setConsumeFactRepository(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
    }

    public ConsumeFact create(ConsumeFact newConsumeFact) {
        return consumeFactRepository.save(newConsumeFact);
    }


    public List<ConsumeFact> getAll() {
        return consumeFactRepository.findAll();
    }


    public Optional<ConsumeFact> getById(int id) {
        return consumeFactRepository.findById(id);
    }

    public void save(int id, ConsumeFact updatedConsumaFact) {
        if (consumeFactRepository.existsById(id)) {
            consumeFactRepository.save(updatedConsumaFact);
        }
    }

    public void delete(int id) {
        consumeFactRepository.deleteById(id);
    }

    public List<ConsumeFact> getByModel(int id) {
        return consumeFactRepository.getByModel(id);
    }

    public List<ConsumeFact> getByRoomId(int roomId) {
        return consumeFactRepository.getByRoomId(roomId);
    }
}
