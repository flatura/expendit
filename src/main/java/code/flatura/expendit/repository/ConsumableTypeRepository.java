package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConsumableTypeRepository extends JpaRepository<ConsumableType, Integer> {
    @Transactional(readOnly = true)
    @Query("SELECT c FROM ConsumableType c WHERE c.name LIKE :name ORDER BY c.name DESC")
    List<ConsumableType> findByName(@Param(value = "name") String name);
}
