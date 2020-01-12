package code.flatura.expendit.service;

import code.flatura.expendit.model.ConsumableType;
import code.flatura.expendit.repository.ConsumableTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumableTypeService {

    private ConsumableTypeRepository consumableTypeRepository;

    public ConsumableTypeService(ConsumableTypeRepository consumableTypeRepository) {
        this.consumableTypeRepository = consumableTypeRepository;
    }

    public ConsumableTypeService() {
    }

    public static void delete(int id) {
    }

    @Autowired
    public void setConsumableTypeRepository(ConsumableTypeRepository consumableTypeRepository) {
        this.consumableTypeRepository = consumableTypeRepository;
    }

    public ConsumableType create(ConsumableType newConsumableType) {
        return consumableTypeRepository.save(newConsumableType);
    }

    public List<ConsumableType> getAll() {
        return consumableTypeRepository.findAll();
    }

    public Optional<ConsumableType> getById(int id) {
        return consumableTypeRepository.findById(id);
    }

    public List<ConsumableType> filter(String name) {
        return consumableTypeRepository.findByName("%" + name + "%");
    }

    public void update(ConsumableType updatedConsumableType, int id) {
        if (updatedConsumableType.getId() == null || consumableTypeRepository.existsById(id))
        {
            consumableTypeRepository.save(updatedConsumableType);
        }
    }
}
