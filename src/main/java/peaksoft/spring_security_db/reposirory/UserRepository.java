package peaksoft.spring_security_db.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.spring_security_db.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = :username")
    public User getUserByUsername (@Param("username")String username);
}