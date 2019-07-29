package code.flatura.expendit.repository;

import code.flatura.expendit.model.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.status = 1")
    List<Consumable> findFull();

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.roomId = roomId")
    List<Consumable> getByRoomId(int roomId);
}
