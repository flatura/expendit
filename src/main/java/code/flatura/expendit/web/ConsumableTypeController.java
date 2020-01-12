package code.flatura.expendit.web;

import code.flatura.expendit.model.ConsumableType;
import code.flatura.expendit.service.ConsumableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/types", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping
    public ResponseEntity<ConsumableType> create(@RequestBody ConsumableType newConsumableType) {
        return new ResponseEntity<>(consumableTypeService.create(newConsumableType), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<java.util.List<ConsumableType>> getAll() {
        return new ResponseEntity<>(consumableTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumableType> getById(@PathVariable("id") int id) {
        return consumableTypeService.getById(id)
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/by")
    public ResponseEntity<List<ConsumableType>> filter(@RequestParam(name = "name", required = false) String name) {
        return new ResponseEntity<>(consumableTypeService.filter(name), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") int id, @RequestBody ConsumableType updatedConsumableType) {
        consumableTypeService.update(updatedConsumableType, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        ConsumableTypeService.delete(id);
    }
}
