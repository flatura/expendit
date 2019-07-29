package code.flatura.expendit.web;

import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.service.ConsumeFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/consumes", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeFact> create(@RequestBody() ConsumeFact newConsumeFact) {
        return new ResponseEntity<>(consumeFactService.create(newConsumeFact), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ConsumeFact>> getAll() {
        return new ResponseEntity<>(consumeFactService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumeFact> getById(@PathVariable("id") int id) {
        return consumeFactService.getById(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>((HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/model/{modelId}")
    public ResponseEntity<List<ConsumeFact>> getByModel(@PathVariable("modelId") int modelId) {
        return new ResponseEntity<>(consumeFactService.getByModel(modelId), HttpStatus.OK);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<ConsumeFact>> getByRoomId(@PathVariable("roomId") int roomId) {
        return new ResponseEntity<>(consumeFactService.getByRoomId(roomId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void save(@PathVariable("id") int id, @RequestBody() ConsumeFact updatedConsumeFact) {
        consumeFactService.save(id, updatedConsumeFact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        consumeFactService.delete(id);
    }
}
