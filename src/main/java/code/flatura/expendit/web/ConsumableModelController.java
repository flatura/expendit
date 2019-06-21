package code.flatura.expendit.web;

import code.flatura.expendit.service.ConsumableModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/model", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsumableModelController {
    private ConsumableModelService dishService;

    public ConsumableModelController(ConsumableModelService dishService) {
        this.dishService = dishService;
    }

    public ConsumableModelController() {
    }

    @Autowired
    public void setDishService(ConsumableModelService dishService) {
        this.dishService = dishService;
    }
}
