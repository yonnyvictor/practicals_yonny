package com.eprod.school.dao.sql2o;



import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.eprod.school.dao.UserDao;
import com.eprod.school.data.Response;
import com.eprod.school.data.User;
import com.eprod.school.utils.DataUtility;
import org.jetbrains.annotations.NotNull;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;

    public Sql2oUserDao(@NotNull Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<User> retrieveItem(@NotNull String username, @NotNull String password) {
        String status = "Active";
        String sql = "SELECT id, director, username, names, designation, last_login lastLogin, status " +
                "FROM users WHERE username = :username AND password = :password AND status = :status";
        try (Connection con = this.sql2o.open()){
            User user = con.createQuery(sql)
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .addParameter("status", status)
                    .executeAndFetchFirst(User.class);

            if(user != null) {
                logUser(user.getId());
                return Optional.of(user);
            }
        }catch (Exception e){
            System.out.println("Error Authenticating User:" + e.getMessage());
        }

        return Optional.empty();
    }



    @Override
    public Response createItem(@NotNull User user) {
        String sql = "INSERT INTO users(director, username, password, names, status, designation) " +
                "VALUES (:director, :username, :password, :names, :status, :designation)";
        try (Connection con = this.sql2o.beginTransaction()){

            if(findItem(user.getUsername())){
                throw new Exception("User with similar username already exists!");
            }

            con.createQuery(sql)
                    .addParameter("director", user.isDirector())
                    .addParameter("username", user.getUsername())
                    .addParameter("password", user.getPassword())
                    .addParameter("names", user.getNames())
                    .addParameter("designation", user.getDesignation())
                    .addParameter("status", user.getStatus())
                    .executeUpdate();
            con.commit();
            return DataUtility.successResponse("User created Successfully");
        }
        catch (Exception e) {
            System.out.println("Failure: " + e.getMessage());
            return DataUtility.errorResponse("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public Response updateItem(@NotNull User user) {
        String sql = "UPDATE users SET director = :director, password = :password, names = :names, designation = :designation, " +
                "status = :status WHERE id = :id";
        try (Connection con = this.sql2o.beginTransaction();){
            con.createQuery( sql)
                    .addParameter("id", user.getId())
                    .addParameter("director", user.isDirector())
                    .addParameter("password", user.getPassword())
                    .addParameter("names", user.getNames())
                    .addParameter("designation", user.getDesignation())
                    .addParameter("status", user.getStatus())
                    .executeUpdate();
            con.commit();
            return DataUtility.successResponse("User updated Successfully");
        }
        catch (Exception e) {
            return DataUtility.errorResponse("Error updating service: " + e.getMessage());
        }
    }

    @Override
    public List<User> retrieveItems() {
        String sql = "SELECT id, director, username, names, designation, last_login lastLogin, status " +
                "FROM users WHERE status = 'Active' ORDER BY username";
        try (Connection con = this.sql2o.open();){
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    private boolean findItem(String username){
        String sql = "SELECT id FROM users WHERE username = :username";

        try (Connection con = this.sql2o.open();){
            Integer integer = con.createQuery(sql).addParameter("username", username).executeScalar(Integer.class);
            if(integer != null)
                return integer > 0;
            return false;
        } catch (Exception e) {
            System.out.println("Error finding User: " + e.getMessage());
            return false;
        }
    }

    private void logUser(int id){
        Date date = new Date();
        String sql = "UPDATE users SET last_login = :lastLogin WHERE id = :id";
        try (final Connection con = sql2o.beginTransaction()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("lastLogin", date)
                    .executeUpdate();

            con.commit();
        } catch (Exception e) {
            System.out.println("Log User Error: " + e.getMessage());
        }
    }
}

