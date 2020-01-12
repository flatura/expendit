package code.flatura.expendit.repository;

import code.flatura.expendit.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT c FROM Facility c WHERE c.name LIKE :name ORDER BY c.name DESC")
    List<Facility> findByName(@Param("name") String name);
}
