package com.eprod.school.api;

import java.util.List;
import java.util.Optional;

import com.eprod.school.data.Response;
import com.eprod.school.data.User;
import org.jetbrains.annotations.NotNull;

public interface UserResource extends Resource {
    Optional<User> retrieveItem(@NotNull String username, @NotNull String password);

    Response createItem(@NotNull User user);

    Response updateItem(@NotNull User user);

    List<User> retrieveItems();
}

