package mk.com.kinmkd.kinmkdreviewservice.web;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkdreviewservice.domain.dto.ReviewDto;
import mk.com.kinmkd.kinmkdreviewservice.domain.model.Review;
import mk.com.kinmkd.kinmkdreviewservice.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<List<Review>> getReviews(@RequestParam Integer locationId,
                                                  @RequestParam(required = false) Integer userId) {
        return ResponseEntity.ok(reviewService.search(locationId, userId));
    }

    @PostMapping("")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(reviewService.save(reviewDto));
    }

    @PutMapping("")
    public void updateReview(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }

    @DeleteMapping("")
    public void deleteReview(@RequestParam Integer locationId,
                             @RequestParam Integer userId) {
        reviewService.delete(locationId, userId);
    }
}
