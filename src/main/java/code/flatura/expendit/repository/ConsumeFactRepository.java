package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumeFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumeFactRepository extends JpaRepository<ConsumeFact, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT c FROM ConsumeFact c WHERE c.consumableModelId = :modelId ORDER BY c.date DESC")
    List<ConsumeFact> getByModelId(@Param("modelId") int id);

    @Transactional(readOnly = true)
    @Query("SELECT c FROM ConsumeFact c WHERE c.roomId = :roomId ORDER BY c.date DESC")
    List<ConsumeFact> getByRoomId(@Param("roomId") int id);

    @Transactional(readOnly = true)
    @Query("SELECT c from ConsumeFact c WHERE c.date BETWEEN :startDate AND :endDate ORDER BY c.date DESC")
    List<ConsumeFact> getBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
