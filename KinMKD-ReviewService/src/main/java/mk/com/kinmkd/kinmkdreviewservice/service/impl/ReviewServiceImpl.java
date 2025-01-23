package mk.com.kinmkd.kinmkdreviewservice.service.impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkdreviewservice.domain.dto.ReviewDto;
import mk.com.kinmkd.kinmkdreviewservice.domain.model.Review;
import mk.com.kinmkd.kinmkdreviewservice.repository.ReviewRepository;
import mk.com.kinmkd.kinmkdreviewservice.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(ReviewDto reviewDto) {
        List<Review> searchResult = search(reviewDto.getLocationId(), reviewDto.getUserId());
        Review review = !searchResult.isEmpty() ? searchResult.get(0) : new Review();
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setUserId(reviewDto.getUserId());
        review.setLocationId(reviewDto.getLocationId());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> search(Integer locationId, Integer userId) {
        if (userId == null) {
            return reviewRepository.findAllByLocationId(locationId);
        }
        Optional<Review> container = reviewRepository.findByUserIdAndLocationId(userId, locationId);
        return container.map(List::of).orElseGet(ArrayList::new);
    }

    @Override
    public void delete(Integer locationId, Integer userId) {
        reviewRepository.findByUserIdAndLocationId(userId, locationId)
                .ifPresent(reviewRepository::delete);
    }
}
