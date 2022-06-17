package com.eprod.school.dao.sql2o;

import com.eprod.school.dao.RegistrationDao;
import com.eprod.school.data.Response;
import com.eprod.school.data.Registration;
import com.eprod.school.data.Student;
import com.eprod.school.utils.DataUtility;
import org.jetbrains.annotations.NotNull;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;

import java.util.ArrayList;
import java.util.List;

public class Sql2oRegistrationDao implements RegistrationDao {

    private final Sql2o sql2o;

    public Sql2oRegistrationDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Response createItem(@NotNull Registration registration) {
        String sql = "INSERT INTO registrations (mode) VALUES (:mode)";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql)
                    .addParameter("mode", registration.getMode())
                    .executeUpdate();
            con.commit();

            return DataUtility.successResponse("Registration created successfully");
        }
        catch (Exception e) {
            System.out.println("Failure: " + e.getMessage());
            return DataUtility.errorResponse("Error creating Registration: " + e.getMessage());
        }
    }

    @Override
    public Response updateItem(@NotNull Registration registration) {
        String sql = "UPDATE registrations SET mode = :mode WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql)
                    .addParameter("id", registration.getId())
                    .addParameter("mode", registration.getMode())
                    .executeUpdate();
            con.commit();
            return DataUtility.successResponse("Registration updated successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error updating Registration: " + e.getMessage());
        }
    }

    @Override
    public Response deleteItem(@NotNull Registration registration) {
        String sql = "DELETE FROM registrations WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql).addParameter("id", registration.getId()).executeUpdate();
            con.commit();

            return DataUtility.successResponse("Registration Deleted successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error deleting Registration: " + e.getMessage());
        }
    }

    @Override
    public List<Registration> retrieveItems(int year) {
        String sql = "SELECT * FROM registrations ";
        ArrayList<Registration> list = new ArrayList<>();
        try (Connection con = this.sql2o.open()){
            con.createQuery(sql).executeAndFetchTable().rows().forEach(rs -> list.add(createRegistration(rs)));
        }
        return list;
    }

    private boolean findItem(@NotNull Registration registration) {
        String sql = "SELECT id FROM registrations WHERE student_id = :studentId AND year = :year";
        try (Connection con = this.sql2o.open();){
            int id = con.createQuery(sql)
                    .addParameter("studentId", registration.getStudentId())
                    .addParameter("year", registration.getYearId())
                    .executeScalar(Integer.class);
            return id > 0;
        }
        catch (Exception e) {
            return false;
        }
    }

    private Registration createRegistration(Row rs){
        return new Registration(
                rs.getInteger(0),
                rs.getInteger(1),
                rs.getInteger(2),
                rs.getInteger(3),
                rs.getInteger(4),
                rs.getString(5),
                rs.getDate(6),
                rs.getDate(7),
                rs.getInteger(8),
                rs.getDate(9),
                rs.getInteger(10),
                rs.getString(11)
        );
    }
}
