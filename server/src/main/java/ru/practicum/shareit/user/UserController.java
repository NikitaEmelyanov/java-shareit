package ru.practicum.shareit.user;

import jakarta.validation.Valid;
import java.util.Collection;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.shareit.user.dto.NewUserRequest;
import ru.practicum.shareit.user.dto.UpdateUserRequest;
import ru.practicum.shareit.user.dto.UserDto;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        log.debug("User controller. Bean UserService created.");
    }

    @GetMapping
    public Collection<UserDto> findAll() {
        log.debug("Method find all users.");
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto findUserById(@PathVariable long userId) {
        log.debug("Method get user by id. Path variable user id is {}", userId);
        return userService.findUserById(userId);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody NewUserRequest newUserRequest) {
        log.debug("Method create user. The body is valid.");
        return userService.saveUser(newUserRequest);
    }

    @PatchMapping("/{userId}")
    public UserDto updateUserById(@Valid @RequestBody UpdateUserRequest updateUserRequest,
        @PathVariable long userId) {
        log.debug("Method update user. The body is valid.");
        log.debug("Method update user. Path variable user id is {}", userId);
        return userService.updateUser(updateUserRequest, userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable long userId) {
        log.debug("Method delete user by id. Path variable user id is {}", userId);
        userService.deleteUserById(userId);
        return ResponseEntity.ok(
            Map.of("result", String.format("User with id %s has been deleted", userId)));
    }
}