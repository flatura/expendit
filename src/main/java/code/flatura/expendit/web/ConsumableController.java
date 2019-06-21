package code.flatura.expendit.web;

import code.flatura.expendit.service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/consumable")
public class ConsumableController {
    private ConsumableService consumableService;

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }

    public ConsumableController() {
    }

    @Autowired
    public void setConsumableService(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }
}
