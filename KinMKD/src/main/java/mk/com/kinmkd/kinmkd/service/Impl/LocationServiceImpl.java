package mk.com.kinmkd.kinmkd.service.Impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkd.model.Location;
import mk.com.kinmkd.kinmkd.model.Review;
import mk.com.kinmkd.kinmkd.model.User;
import mk.com.kinmkd.kinmkd.model.exception.LocationNotFoundException;
import mk.com.kinmkd.kinmkd.repository.CategoryRepository;
import mk.com.kinmkd.kinmkd.repository.LocationRepository;
import mk.com.kinmkd.kinmkd.repository.ReviewRepository;
import mk.com.kinmkd.kinmkd.repository.UserRepository;
import mk.com.kinmkd.kinmkd.service.LocationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public Location findById(Integer id) {
        Location location = locationRepository.findById(id).orElseThrow(LocationNotFoundException::new);
        List<Review> reviews = reviewRepository.getByLocationId(location.getId());
        Map<Integer, String> emailById = userRepository.getEmailsById(reviews.stream().map(Review::getUserId).toList());
        reviews.forEach(review -> review.setUser(new User(emailById.get(review.getUserId()))));
        location.setReviews(reviews);
        return location;
    }

    @Override
    public List<Location> performSearch(String categoryName, String text) {
        return locationRepository.search(categoryRepository.findByName(categoryName).get(), text);
    }
}
