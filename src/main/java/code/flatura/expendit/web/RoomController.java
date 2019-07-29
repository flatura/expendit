package code.flatura.expendit.web;

import code.flatura.expendit.model.Room;
import code.flatura.expendit.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public RoomController() {
    }

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> create(@RequestBody() Room newRoom) {
        return new ResponseEntity<>(roomService.create(newRoom), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAll() {
        return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/facility/{id}")
    public ResponseEntity<List<Room>> getByFacility(@PathVariable("id") int id) {
        return new ResponseEntity<>(roomService.getByFacilityId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable("id") int id) {
        return roomService.getById(id)
        .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody() Room updatedRoom) {
        roomService.update(updatedRoom, id);
    }

    public void delete(@PathVariable("id") int id) {
        roomService.delete(id);
    }


}
