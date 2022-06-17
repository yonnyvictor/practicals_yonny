package com.eprod.school.dao.sql2o;

import com.eprod.school.dao.StudentDao;
import com.eprod.school.data.Response;
import com.eprod.school.data.Student;
import com.eprod.school.utils.DataUtility;
import org.jetbrains.annotations.NotNull;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;

import java.util.ArrayList;
import java.util.List;

public class Sql2oStudentDao implements StudentDao {

    private final Sql2o sql2o;

    public Sql2oStudentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Response createItem(@NotNull Student student) {
        String sql = "INSERT INTO students (first_name) VALUES (:fname)";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql).addParameter("fname", student.getFirstName()).executeUpdate();
            con.commit();

            return DataUtility.successResponse("Student created successfully");
        }
        catch (Exception e) {
            System.out.println("Failure: " + e.getMessage());
            return DataUtility.errorResponse("Error creating Student: " + e.getMessage());
        }
    }

    @Override
    public Response updateItem(@NotNull Student student) {
        String sql = "UPDATE students SET first_name = :fname WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql)
                    .addParameter("id", student.getId())
                    .addParameter("fname", student.getFirstName())
                    .executeUpdate();
            con.commit();
            return DataUtility.successResponse("Student updated successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error updating Student: " + e.getMessage());
        }
    }

    @Override
    public Response deleteItem(@NotNull Student student) {
        String sql = "DELETE FROM students WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql).addParameter("id", student.getId()).executeUpdate();
            con.commit();

            return DataUtility.successResponse("Student created successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error deleting Student: " + e.getMessage());
        }
    }

    @Override
    public List<Student> retrieveItems() {
        String sql = "SELECT * FROM students ";
        ArrayList<Student> list = new ArrayList<>();
        try (Connection con = this.sql2o.open()){
            con.createQuery(sql).executeAndFetchTable().rows().forEach(rs -> list.add(createStudent(rs)));
        }
        return list;
    }

    private boolean findItem(@NotNull String name) {
        String sql = "SELECT id FROM students WHERE name = :name";
        try (Connection con = this.sql2o.open();){
            int id = con.createQuery(sql).addParameter("name", name).executeScalar(Integer.class);
            return id > 0;
        }
        catch (Exception e) {
            return false;
        }
    }

    private Student createStudent(Row rs){
        return new Student(
                rs.getInteger(0),
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10),
                rs.getString(11),
                rs.getString(12),
                rs.getString(13),
                rs.getString(14),
                rs.getString(15),
                rs.getString(16),
                rs.getInteger(16),
                rs.getDate(17),
                rs.getDate(18),
                rs.getDate(19),
                rs.getInteger(20),
                rs.getDate(21),
                rs.getInteger(22),
                rs.getString(23)

        );
    }
}
