package com.eprod.school.dao;

import com.eprod.school.data.Response;
import com.eprod.school.data.Registration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RegistrationDao {
    Response createItem(@NotNull Registration registration);

    Response updateItem(@NotNull Registration registration);

    Response deleteItem(@NotNull Registration registration);

    List<Registration> retrieveItems(int year);
}
