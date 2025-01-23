package mk.com.kinmkd.kinmkduserservice.service.impl;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkduserservice.domain.dto.UserDto;
import mk.com.kinmkd.kinmkduserservice.domain.model.User;
import mk.com.kinmkd.kinmkduserservice.repository.UserRepository;
import mk.com.kinmkd.kinmkduserservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User register(UserDto userDto) {
        User user = new User(userDto.getEmail(), userDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Map<Integer, String> mapIdsToEmails(List<Integer> ids) {
        Map<Integer, String> emailsById = new HashMap<>();
        ids.stream()
                .map(id -> userRepository.findById(id).get())
                .forEach(user -> emailsById.put(user.getId(), user.getEmail()));
        return emailsById;
    }
}
