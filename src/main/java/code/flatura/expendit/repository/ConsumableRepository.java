package code.flatura.expendit.repository;

import code.flatura.expendit.model.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.status = 1")
    List<Consumable> getFull();

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.roomId = roomId ORDER BY c.name DESC")
    List<Consumable> getByRoomId(int roomId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Consumable c SET c.status = 2, c.roomId = :roomId WHERE (c.status = 1 AND c.id = :id)")
    void install(@Param("id") int id, @Param("roomId") int roomId);
}
