package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumeFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumeFactRepository extends JpaRepository<ConsumeFact, Integer> {

    @Query("SELECT c FROM ConsumeFact c WHERE c.consumableModelId = id")
    List<ConsumeFact> getByModel(int id);

    @Query("SELECT c FROM ConsumeFact c WHERE c.roomId = id")
    List<ConsumeFact> getByRoomId(int id);
}
