package code.flatura.expendit.repository;

import code.flatura.expendit.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "SELECT r FROM Room r WHERE r.facilityId = id")
    List<Room> getByFacilityId(int id);
}
