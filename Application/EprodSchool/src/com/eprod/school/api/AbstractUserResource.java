package com.eprod.school.api;

import com.eprod.school.dao.UserDao;
import com.eprod.school.data.Response;
import com.eprod.school.data.User;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractUserResource implements UserResource {
    private final UserDao userDao;

    protected AbstractUserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> retrieveItem(@NotNull String username, @NotNull String password) {
        return this.userDao.retrieveItem(username, password);
    }

    @Override
    public Response createItem(@NotNull User user) {
        return this.userDao.createItem(user);
    }

    @Override
    public Response updateItem(@NotNull User user) {
        return this.userDao.updateItem(user);
    }

    @Override
    public List<User> retrieveItems() {
        return this.userDao.retrieveItems();
    }
}

