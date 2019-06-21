package code.flatura.expendit.service;

import code.flatura.expendit.repository.ConsumableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumableService {

    private ConsumableRepository consumableRepository;

    public ConsumableService(ConsumableRepository consumableRepository) {
        this.consumableRepository = consumableRepository;
    }

    public ConsumableService() {
    }

    @Autowired
    public void setConsumableRepository(ConsumableRepository consumableRepository) {
        this.consumableRepository = consumableRepository;
    }
}
