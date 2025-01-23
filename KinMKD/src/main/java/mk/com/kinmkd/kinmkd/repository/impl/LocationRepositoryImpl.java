package mk.com.kinmkd.kinmkd.repository.impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkd.model.Category;
import mk.com.kinmkd.kinmkd.model.Location;
import mk.com.kinmkd.kinmkd.repository.ApiUrls;
import mk.com.kinmkd.kinmkd.repository.LocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {
    private final ApiUrls apiUrls;
    private final RestTemplate restTemplate;

    @Override
    public List<Location> search(Category category, String keyword) {
        ResponseEntity<Location[]> response = restTemplate.getForEntity(String.format("%s/api/locations?category=%s&keyword=%s", apiUrls.getLocationServiceUrl(), category, keyword), Location[].class);
        return Arrays.stream(response.getBody()).toList();
    }

    @Override
    public Optional<Location> findById(Integer id) {
        ResponseEntity<Location> response = restTemplate.getForEntity(String.format("%s/api/locations/%d", apiUrls.getLocationServiceUrl(), id), Location.class);
        return Optional.ofNullable(response.getBody());
    }
}
