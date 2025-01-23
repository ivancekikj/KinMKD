package mk.com.kinmkd.kinmkd.repository;

import mk.com.kinmkd.kinmkd.model.User;
import mk.com.kinmkd.kinmkd.model.dto.UserDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(UserDto userDto);
    Map<Integer, String> getEmailsById(List<Integer> ids);
}
