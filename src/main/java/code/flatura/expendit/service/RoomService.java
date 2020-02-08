package code.flatura.expendit.service;

import code.flatura.expendit.model.ConsumableStatus;
import code.flatura.expendit.model.Room;
import code.flatura.expendit.repository.ConsumableRepository;
import code.flatura.expendit.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        // Delete room only if it doesn't have new consumables in it TODO maybe any of type?
        if (consumableRepository.findByRoomId(id).stream().noneMatch(c -> c.getStatus() == ConsumableStatus.NEW))
            roomRepository.deleteById(id);
    }

    public List<Room> filter(Integer facilityId, String name) {
        List<Room> result = new ArrayList<>();
        String nameLike = "%" + name + "%";
        if (facilityId != null && name != null) result = roomRepository.filter(facilityId, nameLike);
        else if (facilityId != null) result = roomRepository.findByFacilityId(facilityId);
        else if (name != null) result = roomRepository.findByName(nameLike);
        return result;
    }
}
