package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumableModelRepository extends JpaRepository<ConsumableModel, Integer> {
}
