package code.flatura.expendit.repository;

import code.flatura.expendit.model.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Integer> {
}
