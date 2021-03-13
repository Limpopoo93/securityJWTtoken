package task.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.company.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
