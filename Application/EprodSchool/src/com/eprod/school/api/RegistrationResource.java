package com.eprod.school.api;

import com.eprod.school.data.Registration;
import com.eprod.school.data.Response;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RegistrationResource extends Resource{
    Response createItem(@NotNull Registration registration);

    Response updateItem(@NotNull Registration registration);

    Response deleteItem(@NotNull Registration registration);

    List<Registration> retrieveItems(int year);
}
