package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumableStatus;
import code.flatura.expendit.model.StatisticsEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsEntry, Integer> {

    @Transactional(readOnly = true)
    //@Query("SELECT new StatisticsEntry(c.consumableModelId, count(c.id)) from ConsumeFact c WHERE c.date BETWEEN :startDate AND :endDate GROUP BY c.consumableModelId")
    @Query( "SELECT new StatisticsEntry(m.id, m.name, count(c.id))" +
            "FROM ConsumeFact c, ConsumableModel m " +
            "WHERE m.id = c.consumableModelId AND (c.date BETWEEN :startDate AND :endDate)" +
            "GROUP BY m.name, m.id" )
    List<StatisticsEntry> countGroupedByModelIdAndBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Transactional(readOnly = true)
    @Query( "SELECT new StatisticsEntry(m.id, m.name, count(c.id))" +
            "FROM Consumable c, ConsumableModel m " +
            "WHERE m.id = c.consumableModelId AND c.status = 1 " +
            "GROUP BY m.name, m.id" )
    List<StatisticsEntry> getAllAvailableAmountOfConsumables();

    @Transactional(readOnly = true)
    @Query( "SELECT new StatisticsEntry(m.id, m.name, count(c.id))" +
            "FROM Consumable c, ConsumableModel m " +
            "WHERE m.id = c.consumableModelId AND m.id = :id AND c.status = :status " +
            "GROUP BY m.name, m.id" )
    StatisticsEntry getAmountOfConsumable(@Param("id") Integer modelId, @Param("status") ConsumableStatus status);
}