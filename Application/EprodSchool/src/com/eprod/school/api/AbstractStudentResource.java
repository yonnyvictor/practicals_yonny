package com.eprod.school.api;

import com.eprod.school.dao.StudentDao;
import com.eprod.school.data.Response;
import com.eprod.school.data.Student;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class AbstractStudentResource implements StudentResource{
    private final StudentDao studentDao;

    public AbstractStudentResource(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public Response createItem(@NotNull Student student) {
        return this.studentDao.createItem(student);
    }

    @Override
    public Response updateItem(@NotNull Student student) {
        return this.studentDao.updateItem(student);
    }

    @Override
    public Response deleteItem(@NotNull Student student) {
        return this.studentDao.deleteItem(student);
    }

    @Override
    public List<Student> retrieveItems() {
        return this.studentDao.retrieveItems();
    }
}
