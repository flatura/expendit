package code.flatura.expendit.web;

import code.flatura.expendit.service.ConsumableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(value = "/api/type", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsumableTypeController {
    private ConsumableTypeService consumableTypeService;

    public ConsumableTypeController(ConsumableTypeService consumableTypeService) {
        this.consumableTypeService = consumableTypeService;
    }

    public ConsumableTypeController() {
    }

    @Autowired
    public void setConsumableTypeService(ConsumableTypeService consumableTypeService) {
        this.consumableTypeService = consumableTypeService;
    }
}
