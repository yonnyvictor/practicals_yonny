package com.eprod.school.dao.sql2o;

import com.eprod.school.dao.StreamDao;
import com.eprod.school.data.Stream;
import com.eprod.school.data.Response;
import com.eprod.school.utils.DataUtility;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oStreamDao implements StreamDao {
    private final Sql2o sql2o;

    public Sql2oStreamDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Response createItem(@NotNull Stream stream) {
        String sql = "INSERT INTO banks (name) VALUES (:name)";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql).addParameter("name", stream.getName()).executeUpdate();
            con.commit();

            return DataUtility.successResponse("Stream created successfully");
        }
        catch (Exception e) {
            System.out.println("Failure: " + e.getMessage());
            return DataUtility.errorResponse("Error creating Stream: " + e.getMessage());
        }
    }

    @Override
    public Response updateItem(@NotNull Stream stream) {
        String sql = "UPDATE banks SET name = :name WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql)
                    .addParameter("id", stream.getId())
                    .addParameter("name", stream.getName())
                    .executeUpdate();
            con.commit();
            return DataUtility.successResponse("Stream updated successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error updating Stream: " + e.getMessage());
        }
    }

    @Override
    public Response deleteItem(@NotNull Stream stream) {
        String sql = "DELETE FROM banks WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery(sql).addParameter("id", stream.getId()).executeUpdate();
            con.commit();

            return DataUtility.successResponse("Stream Account created successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error deleting Stream: " + e.getMessage());
        }
    }

    @Override
    public List<Stream> retrieveItems() {
        String sql = "SELECT id, name FROM banks ";
        ArrayList<Stream> list = new ArrayList<>();
        try (Connection con = this.sql2o.open()){
            con.createQuery(sql).executeAndFetchTable().rows().forEach(rs -> list.add(new Stream(rs.getInteger(0), rs.getString(1))));
        }
        return list;
    }

    private boolean findItem(@NotNull String name) {
        String sql = "SELECT id, name FROM banks WHERE name = :name";
        try (Connection con = this.sql2o.open();){
            int id = con.createQuery(sql).addParameter("name", name).executeScalar(Integer.class);
            return id > 0;
        }
        catch (Exception e) {
            return false;
        }
    }
}

