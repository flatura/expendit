package code.flatura.expendit.repository;

import code.flatura.expendit.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Query("SELECT ur.role FROM UserRole ur, User u WHERE u.name=:name and ur.user_id=u.id")
    ArrayList<String> findByName(String name);
}
