package code.flatura.expendit.webapi;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ConsumableController.REST_URL)
public class ConsumableController {
    static final String REST_URL = "/api/consumables";

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Consumable> create(@RequestBody Consumable newConsumable) {
        return new ResponseEntity<>(consumableService.create(newConsumable), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Consumable>> getAll() {
        return new ResponseEntity<>(consumableService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Consumable> getById(@PathVariable("id") int id) {
        return consumableService.getById(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/by")
    public ResponseEntity<List<Consumable>> getBy(@RequestParam(name = "status", required = false) Integer status,
                                                  @RequestParam(name = "room", required = false) Integer roomId,
                                                  @RequestParam(name = "name", required = false) String name) {
        return new ResponseEntity<>(consumableService.getBy(roomId, status, name), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") int id, @RequestBody Consumable consumable) {
        consumableService.update(consumable, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        consumableService.delete(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void install(@RequestParam("consumableId") int consumableId,
                        @RequestParam("roomId") int roomId) {
        consumableService.install(consumableId, roomId);
    }
}
