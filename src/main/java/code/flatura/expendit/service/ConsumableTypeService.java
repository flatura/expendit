package code.flatura.expendit.service;

import code.flatura.expendit.repository.ConsumableTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumableTypeService {

    private ConsumableTypeRepository consumableTypeRepository;

    public ConsumableTypeService(ConsumableTypeRepository consumableTypeRepository) {
        this.consumableTypeRepository = consumableTypeRepository;
    }

    public ConsumableTypeService() {
    }

    @Autowired
    public void setConsumableTypeRepository(ConsumableTypeRepository consumableTypeRepository) {
        this.consumableTypeRepository = consumableTypeRepository;
    }
}
