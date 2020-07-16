package code.flatura.expendit.repository;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.model.ConsumableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.status = :status")
    List<Consumable> findByStatus(@Param("status") int status);

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.roomId = :roomId ORDER BY c.name DESC")
    List<Consumable> findByRoomId(@Param("roomId")int roomId);

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.roomId = :roomId AND c.status = :status ORDER BY c.name DESC")
    List<Consumable> findByRoomIdAndStatus(@Param("roomId") int roomId, @Param("status") int status);

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Consumable c WHERE c.name LIKE :name ORDER BY c.name DESC")
    List<Consumable> findByName(@Param("name") String name);

    @Query
    Optional<Consumable> findFirstByConsumableModelIdAndStatus(Integer consumableModelId, ConsumableStatus status);


    //TODO installMany()
    /*
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Consumable c SET status = 2, room_id = :roomId WHERE status = 1 LIMIT :limit", nativeQuery = true)
    void installMany(@Param("model_id") int modeid, @Param("limit") int limit, @Param("roomqId") int roomId);
    */
}
