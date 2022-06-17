package com.eprod.school.dao.sql2o;

import com.eprod.school.dao.LevelDao;
import com.eprod.school.data.Level;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oLevelDao implements LevelDao {
    private final Sql2o sql2o;

    public Sql2oLevelDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Level> retrieveItems() {
        String sql = "SELECT id, name, category FROM levels";
        try (Connection con = this.sql2o.open();){
            return con.createQuery(sql).executeAndFetch(Level.class);
        }
    }
}

