package code.flatura.expendit.web;

import code.flatura.expendit.service.ConsumeFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/consume", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsumeFactController {
    private ConsumeFactService consumeFactService;

    public ConsumeFactController(ConsumeFactService consumeFactService) {
        this.consumeFactService = consumeFactService;
    }

    public ConsumeFactController() {
    }

    @Autowired
    public void setConsumeFactService(ConsumeFactService consumeFactService) {
        this.consumeFactService = consumeFactService;
    }
}
