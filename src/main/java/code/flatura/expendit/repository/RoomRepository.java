package code.flatura.expendit.repository;

import code.flatura.expendit.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Transactional
    @Query(value = "SELECT r FROM Room r WHERE r.facilityId = :id AND r.name LIKE :name ORDER BY r.name")
    List<Room> filter(@Param("id") int facilityId, @Param("name") String name);

    @Transactional
    @Query(value = "SELECT r FROM Room r WHERE r.facilityId = :id ORDER BY r.name")
    List<Room> findByFacilityId(@Param("id") int facilityId);

    @Transactional
    @Query(value = "SELECT r FROM Room r WHERE r.name LIKE :name ORDER BY r.id")
    List<Room> findByName(@Param("name") String name);

}
