package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ConsumableModel, Integer> {
    @Transactional(readOnly = true)
    @Query("SELECT c FROM ConsumableModel c WHERE c.consumableTypeId = :typeId AND c.name LIKE :name ORDER BY c.name DESC")
    List<ConsumableModel> findByTypeAndName(@Param(value = "typeId") int typeId, @Param(value = "name") String name);

    @Transactional(readOnly = true)
    @Query("SELECT c FROM ConsumableModel c WHERE c.consumableTypeId = :typeId ORDER BY c.name DESC")
    List<ConsumableModel> findByType(@Param(value = "typeId") int typeId);

    @Transactional(readOnly = true)
    @Query("SELECT c FROM ConsumableModel c WHERE c.name LIKE :name ORDER BY c.name DESC")
    List<ConsumableModel> findByName(@Param(value = "name") String name);
}
