package mk.com.kinmkd.kinmkd.repository.impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkd.model.Review;
import mk.com.kinmkd.kinmkd.model.dto.ReviewDto;
import mk.com.kinmkd.kinmkd.repository.ApiUrls;
import mk.com.kinmkd.kinmkd.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
    private final RestTemplate restTemplate;
    private final ApiUrls apiUrls;

    @Override
    public Optional<Review> get(Integer locationId, Integer reviewId) {
        ResponseEntity<Review[]> response = restTemplate.getForEntity(
                String.format("%s/api/reviews?locationId=%d&userId=%d", apiUrls.getReviewServiceUrl(), locationId, reviewId),
                Review[].class
        );
        return response.getBody().length == 0 ? Optional.empty() : Optional.of(response.getBody()[0]);
    }

    @Override
    public List<Review> getByLocationId(Integer locationId) {
        ResponseEntity<Review[]> response = restTemplate.getForEntity(
                String.format("%s/api/reviews?locationId=%d", apiUrls.getReviewServiceUrl(), locationId),
                Review[].class
        );
        return Arrays.stream(response.getBody()).toList();
    }

    @Override
    public Review create(ReviewDto review) {
        ResponseEntity<Review> response = restTemplate.postForEntity(String.format("%s/api/reviews", apiUrls.getReviewServiceUrl()), review, Review.class);
        return response.getBody();
    }

    @Override
    public void update(ReviewDto review) {
        restTemplate.put(String.format("%s/api/reviews", apiUrls.getReviewServiceUrl()), review);
    }

    @Override
    public void delete(Integer locationId, Integer reviewId) {
        restTemplate.delete(String.format("%s/api/reviews?locationId=%d&userId=%d", apiUrls.getReviewServiceUrl(), locationId, reviewId));
    }
}
