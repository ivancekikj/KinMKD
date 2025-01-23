package mk.com.kinmkd.kinmkduserservice.repository;

import mk.com.kinmkd.kinmkduserservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}