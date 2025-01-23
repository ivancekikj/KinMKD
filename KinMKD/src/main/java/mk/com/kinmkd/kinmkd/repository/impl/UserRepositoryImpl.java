package mk.com.kinmkd.kinmkd.repository.impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkd.model.User;
import mk.com.kinmkd.kinmkd.model.dto.UserDto;
import mk.com.kinmkd.kinmkd.repository.ApiUrls;
import mk.com.kinmkd.kinmkd.repository.UserRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final RestTemplate restTemplate;
    private final ApiUrls apiUrls;

    @Override
    public Optional<User> findByEmail(String email) {
        ResponseEntity<User> response = restTemplate.getForEntity(String.format("%s/api/users/%s", apiUrls.getUserServiceUrl(), email), User.class);
        if (!response.hasBody())
            return Optional.empty();
        return Optional.ofNullable(response.getBody());
    }

    @Override
    public User save(UserDto userDto) {
        ResponseEntity<User> response = restTemplate.postForEntity(String.format("%s/api/users", apiUrls.getUserServiceUrl()), userDto, User.class);
        return response.getBody();
    }

    @Override
    public Map<Integer, String> getEmailsById(List<Integer> ids) {
        ResponseEntity<Map<Integer, String>> response = restTemplate.exchange(
                String.format("%s/api/users/emails?ids=%s", apiUrls.getUserServiceUrl(), ids.stream().map(String::valueOf).collect(Collectors.joining(","))),
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }
}
