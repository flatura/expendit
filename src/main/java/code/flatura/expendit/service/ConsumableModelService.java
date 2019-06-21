package code.flatura.expendit.service;

import code.flatura.expendit.repository.ConsumableModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
