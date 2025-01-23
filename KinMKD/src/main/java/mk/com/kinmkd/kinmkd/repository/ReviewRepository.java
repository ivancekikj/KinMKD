package mk.com.kinmkd.kinmkd.repository;

import mk.com.kinmkd.kinmkd.model.Review;
import mk.com.kinmkd.kinmkd.model.dto.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
     Optional<Review> get(Integer locationId, Integer reviewId);
     List<Review> getByLocationId(Integer locationId);
     Review create(ReviewDto review);
     void update(ReviewDto review);
     void delete(Integer locationId, Integer reviewId);
}
