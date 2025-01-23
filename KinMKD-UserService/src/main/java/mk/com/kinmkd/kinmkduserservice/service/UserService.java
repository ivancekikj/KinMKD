package mk.com.kinmkd.kinmkduserservice.service;

import mk.com.kinmkd.kinmkduserservice.domain.dto.UserDto;
import mk.com.kinmkd.kinmkduserservice.domain.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    User register(UserDto userDto);
    Optional<User> findByEmail(String email);
    Map<Integer, String> mapIdsToEmails(List<Integer> ids);
}