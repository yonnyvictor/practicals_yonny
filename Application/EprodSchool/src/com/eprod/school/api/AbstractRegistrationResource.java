package com.eprod.school.api;

import com.eprod.school.dao.RegistrationDao;
import com.eprod.school.data.Response;
import com.eprod.school.data.Registration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class AbstractRegistrationResource implements RegistrationResource{
    private final RegistrationDao registrationDao;

    public AbstractRegistrationResource(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }


    @Override
    public Response createItem(@NotNull Registration registration) {
        return this.registrationDao.createItem(registration);
    }

    @Override
    public Response updateItem(@NotNull Registration registration) {
        return this.registrationDao.updateItem(registration);
    }

    @Override
    public Response deleteItem(@NotNull Registration registration) {
        return this.registrationDao.deleteItem(registration);
    }

    @Override
    public List<Registration> retrieveItems(int year) {
        return this.registrationDao.retrieveItems(year);
    }
}
