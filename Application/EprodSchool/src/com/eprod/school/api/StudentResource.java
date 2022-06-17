package com.eprod.school.api;

import com.eprod.school.data.Response;
import com.eprod.school.data.Student;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface StudentResource extends Resource{
    Response createItem(@NotNull Student student);

    Response updateItem(@NotNull Student student);

    Response deleteItem(@NotNull Student student);

    List<Student> retrieveItems();
}
