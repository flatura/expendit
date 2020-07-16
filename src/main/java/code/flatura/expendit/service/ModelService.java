package code.flatura.expendit.service;

import code.flatura.expendit.model.ConsumableModel;
import code.flatura.expendit.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    private ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public ModelService() {
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<ConsumableModel> getAll() {
        return modelRepository.findAll();
    }

    public Optional<ConsumableModel> getById(int id) {
        return modelRepository.findById(id);
    }

    public ConsumableModel create(ConsumableModel newConsumableModel) {
        return modelRepository.save(newConsumableModel);
    }

    public void update(ConsumableModel updatedConsumableModel, int id) {
        if (updatedConsumableModel.getId() == null || modelRepository.existsById(id))
        {
            modelRepository.save(updatedConsumableModel);
        }
    }

    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    public List<ConsumableModel> filter(Integer typeId, String name) {
        List<ConsumableModel> result = new ArrayList<>();
        if (typeId != null && name != null) {
            result = modelRepository.findByTypeAndName(typeId, "%" + name + "%");
        } else if (typeId != null) {
            result = modelRepository.findByType(typeId);
        } else if (name  != null) {
            result = modelRepository.findByName("%" + name + "%");
        }
        return result;
    }


}
