package code.flatura.expendit.repository;

import code.flatura.expendit.model.ConsumeFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumeFactRepository extends JpaRepository<ConsumeFact, Integer> {
}
