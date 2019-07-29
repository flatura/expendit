package code.flatura.expendit.web;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/consumables")
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

    @GetMapping(value = "/full")
    public ResponseEntity<List<Consumable>> getFull() {
        return new ResponseEntity<>(consumableService.getFull(), HttpStatus.OK);
    }

    @GetMapping(value = "/room/{roomId}")
    public ResponseEntity<List<Consumable>> getByRoomId(@PathVariable("roomId") int roomId) {
        return new ResponseEntity<>(consumableService.getByRoomId(roomId), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") int id, @RequestBody Consumable consumable) {
        consumable.setId(null);
        consumableService.update(consumable, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        consumableService.delete(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void install(@RequestParam("consumableId") int consuambleId,
                        @RequestParam("roomId") int roomId) {
        consumableService.install(consuambleId, roomId);
    }
}
