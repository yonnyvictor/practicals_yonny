package com.eprod.school.dao;

import com.eprod.school.data.Response;
import com.eprod.school.data.Student;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface StudentDao {
    Response createItem(@NotNull Student student);

    Response updateItem(@NotNull Student student);

    Response deleteItem(@NotNull Student student);

    List<Student> retrieveItems();
}
