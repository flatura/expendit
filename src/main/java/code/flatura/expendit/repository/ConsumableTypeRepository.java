package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumableTypeRepository extends JpaRepository<ConsumableType, Integer> {
}
