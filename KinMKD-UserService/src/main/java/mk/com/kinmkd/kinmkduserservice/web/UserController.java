package mk.com.kinmkd.kinmkduserservice.web;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkduserservice.domain.dto.UserDto;
import mk.com.kinmkd.kinmkduserservice.domain.model.User;
import mk.com.kinmkd.kinmkduserservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<User> login(@PathVariable("email") String email) {
        Optional<User> container = userService.findByEmail(email);
        return ResponseEntity.ok(container.orElse(null));
    }

    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/emails")
    public ResponseEntity<Map<Integer, String>> getUserEmails(@RequestParam List<Integer> ids) {
        return ResponseEntity.ok(userService.mapIdsToEmails(ids));
    }
}
