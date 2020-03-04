package code.flatura.expendit.webapi;

import code.flatura.expendit.model.ConsumeFact;
import code.flatura.expendit.service.ConsumeFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @GetMapping("/between")
    public ResponseEntity<List<ConsumeFact>> getBetween(
            @Valid @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Valid @RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(
                consumeFactService.getBetweenDates(
                    startDate,
                    endDate),
                    HttpStatus.OK);
    }


    @GetMapping("/model/{modelId}")
    public ResponseEntity<List<ConsumeFact>> getByModel(@PathVariable("modelId") int modelId) {
        return new ResponseEntity<>(consumeFactService.getByModelId(modelId), HttpStatus.OK);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<ConsumeFact>> getByRoomId(@PathVariable("roomId") int roomId) {
        return new ResponseEntity<>(consumeFactService.getByRoomId(roomId), HttpStatus.OK);
    }

    @GetMapping("/by")
    public ResponseEntity<List<ConsumeFact>> getBy(@RequestParam(name = "modelId", required = false) Integer modelId,
                                                   @RequestParam(name = "roomId", required = false) Integer roomId) {
        return new ResponseEntity<>(consumeFactService.getBy(roomId, modelId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        consumeFactService.delete(id);
    }
}
