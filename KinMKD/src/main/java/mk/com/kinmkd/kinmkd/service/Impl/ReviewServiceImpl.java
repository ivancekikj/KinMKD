package mk.com.kinmkd.kinmkd.service.Impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkd.model.Review;
import mk.com.kinmkd.kinmkd.model.dto.ReviewDto;
import mk.com.kinmkd.kinmkd.model.exception.LocationNotFoundException;
import mk.com.kinmkd.kinmkd.repository.LocationRepository;
import mk.com.kinmkd.kinmkd.repository.ReviewRepository;
import mk.com.kinmkd.kinmkd.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final LocationRepository locationRepository;

    @Override
    public Optional<Review> findByUserIdAndLocationId(Integer userId, Integer locationId) {
        return reviewRepository.get(locationId, userId);
    }

    @Override
    public Review create(Integer rating, String comment, Integer userId, Integer locationId) {
        locationRepository.findById(locationId).orElseThrow(LocationNotFoundException::new);
        Optional<Review> container = reviewRepository.get(locationId, userId);
        if (container.isEmpty()) {
            return reviewRepository.create(new ReviewDto(rating, comment, userId, locationId));
        } else {
            reviewRepository.update(new ReviewDto(rating, comment, userId, locationId));
            Review review = container.get();
            review.setRating(rating);
            review.setComment(comment);
            return review;
        }
    }

    @Override
    public void deleteByUserIdAndLocationId(Integer userId, Integer locationId) {
        reviewRepository.delete(locationId, userId);
    }
}
