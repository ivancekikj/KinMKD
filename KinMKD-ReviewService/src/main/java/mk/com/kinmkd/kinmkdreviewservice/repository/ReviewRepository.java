package mk.com.kinmkd.kinmkdreviewservice.repository;

import mk.com.kinmkd.kinmkdreviewservice.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    Optional<Review> findByUserIdAndLocationId(Integer userId, Integer locationId);
    List<Review> findAllByLocationId(Integer locationId);
}