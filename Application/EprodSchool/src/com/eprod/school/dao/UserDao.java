package com.eprod.school.dao;

import java.util.List;
import java.util.Optional;

import com.eprod.school.data.Response;
import com.eprod.school.data.User;
import org.jetbrains.annotations.NotNull;

public interface UserDao {
    Optional<User> retrieveItem(@NotNull String username, @NotNull String password);

    Response createItem(@NotNull User user);

    Response updateItem(@NotNull User user);

    List<User> retrieveItems();
}

