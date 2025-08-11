package ru.practicum.shareit.user.dao;

import java.util.Optional;
import ru.practicum.shareit.user.model.User;

public interface UserRepository {

    boolean containsEmail(String email);

    long addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(long userId);

    Optional<User> getUser(long userId);
}