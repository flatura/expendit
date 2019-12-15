package code.flatura.expendit.web;

import code.flatura.expendit.model.ConsumableModel;
import code.flatura.expendit.service.ConsumableModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/consumablemodels", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsumableModelController {
    private ConsumableModelService consumableModelService;

    public ConsumableModelController(ConsumableModelService consumableModelService) {
        this.consumableModelService = consumableModelService;
    }

    public ConsumableModelController() {
    }

    @Autowired
    public void setConsumableModelService(ConsumableModelService consumableModelService) {
        this.consumableModelService = consumableModelService;
    }

    @PostMapping
    public ResponseEntity<ConsumableModel> create(@RequestBody ConsumableModel newConsumableModel) {
        return new ResponseEntity<>(consumableModelService.create(newConsumableModel), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ConsumableModel>> getAll() {
        return new ResponseEntity<>(consumableModelService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumableModel> getById(@PathVariable("id") int id) {
        return consumableModelService.getById(id)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") int id, @RequestBody ConsumableModel updatedConsumableModel) {
        consumableModelService.update(updatedConsumableModel, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        consumableModelService.delete(id);
    }

    //@ResponseStatus(value = HttpStatus.NO_CONTENT)
}
