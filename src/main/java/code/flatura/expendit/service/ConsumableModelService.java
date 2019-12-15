package code.flatura.expendit.service;

import code.flatura.expendit.model.ConsumableModel;
import code.flatura.expendit.repository.ConsumableModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumableModelService {

    private ConsumableModelRepository consumableModelRepository;

    public ConsumableModelService(ConsumableModelRepository consumableModelRepository) {
        this.consumableModelRepository = consumableModelRepository;
    }

    public ConsumableModelService() {
    }

    @Autowired
    public void setConsumableModelRepository(ConsumableModelRepository consumableModelRepository) {
        this.consumableModelRepository = consumableModelRepository;
    }

    public List<ConsumableModel> getAll() {
        return consumableModelRepository.findAll();
    }

    public Optional<ConsumableModel> getById(int id) {
        return consumableModelRepository.findById(id);
    }

    public ConsumableModel create(ConsumableModel newConsumableModel) {
        return consumableModelRepository.save(newConsumableModel);
    }

    public void update(ConsumableModel updatedConsumableModel, int id) {
        if (updatedConsumableModel.getId() == null || consumableModelRepository.existsById(id))
        {
            consumableModelRepository.save(updatedConsumableModel);
        }
    }

    public void delete(int id) {
        consumableModelRepository.deleteById(id);
    }
}
