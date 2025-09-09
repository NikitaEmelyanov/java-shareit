package ru.practicum.shareit.user;

import java.util.Collection;
import ru.practicum.shareit.user.dto.NewUserRequest;
import ru.practicum.shareit.user.dto.UpdateUserRequest;
import ru.practicum.shareit.user.dto.UserDto;

public interface UserService {

    Collection<UserDto> getAllUsers();

    UserDto findUserById(long userId);

    UserDto saveUser(NewUserRequest user);

    UserDto updateUser(UpdateUserRequest user, long userId);

    void deleteUserById(long userId);
}