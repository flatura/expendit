package code.flatura.expendit.webapi;

import code.flatura.expendit.model.ConsumableModel;
import code.flatura.expendit.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/models", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsumableModelController {
    private ModelService modelService;

    public ConsumableModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    public ConsumableModelController() {
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<ConsumableModel> create(@RequestBody ConsumableModel newConsumableModel) {
        return new ResponseEntity<>(modelService.create(newConsumableModel), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ConsumableModel>> getAll() {
        return new ResponseEntity<>(modelService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumableModel> getById(@PathVariable("id") int id) {
        return modelService.getById(id)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/by")
    public ResponseEntity<List<ConsumableModel>> filter(@RequestParam(name = "typeId", required = false) Integer typeId,
                                                  @RequestParam(name = "name", required = false) String name) {
        return new ResponseEntity<>(modelService.filter(typeId, name), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") int id, @RequestBody ConsumableModel updatedConsumableModel) {
        modelService.update(updatedConsumableModel, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        modelService.delete(id);
    }
}
