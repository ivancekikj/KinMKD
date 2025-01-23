package mk.com.kinmkd.kinmkdreviewservice.service;

import mk.com.kinmkd.kinmkdreviewservice.domain.dto.ReviewDto;
import mk.com.kinmkd.kinmkdreviewservice.domain.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(ReviewDto reviewDto);
    List<Review> search(Integer locationId, Integer userId);
    void delete(Integer locationId, Integer userId);
}
