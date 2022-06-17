package com.eprod.school.data;

import java.util.Date;

public class User {
    private int id;
    private boolean director;
    private String username;
    private String password;
    private String names;
    private String designation;
    private String status;
    private Date lastLogin;

    public User() {
    }

    public User(int id, boolean director, String username, String password, String names, String designation, Date lastLogin, String status) {
        this.id = id;
        this.director = director;
        this.username = username;
        this.password = password;
        this.names = names;
        this.designation = designation;
        this.lastLogin = lastLogin;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDirector() {
        return director;
    }

    public void setDirector(boolean director) {
        this.director = director;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}

