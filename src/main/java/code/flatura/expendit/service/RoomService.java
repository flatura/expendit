package code.flatura.expendit.service;

import code.flatura.expendit.model.Room;
import code.flatura.expendit.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomService() {
    }

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room create(Room newRoom) {
        return roomRepository.save(newRoom);
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public List<Room> getByFacilityId(int id) {
        return roomRepository.getByFacilityId(id);
    }

    public Optional<Room> getById(int id) {
        return roomRepository.findById(id);
    }

    public void update(Room updatedRoom, int id) {
        if (updatedRoom.getId() == null || roomRepository.existsById(id)) {
            roomRepository.save(updatedRoom);
        }
    }

    public void delete(int id) {
        roomRepository.deleteById(id);
    }
}
