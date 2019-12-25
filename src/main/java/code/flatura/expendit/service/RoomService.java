package code.flatura.expendit.service;

import code.flatura.expendit.model.Room;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepository roomRepository;
    private ConsumableRepository consumableRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, ConsumableRepository consumableRepository) {
        this.roomRepository = roomRepository;
        this.consumableRepository = consumableRepository;
    }

    public RoomService() {
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

    @Transactional
    public void delete(int id) {
        // Delete room only if it doesn't have new consumables in it
        if (consumableRepository.getByRoomId(id).stream().noneMatch(c -> c.getStatus() == 1))
            roomRepository.deleteById(id);
    }
}
