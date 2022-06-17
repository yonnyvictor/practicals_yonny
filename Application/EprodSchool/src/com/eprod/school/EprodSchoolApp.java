package com.eprod.school;


import com.eprod.school.api.javalin.*;
import com.eprod.school.dao.sql2o.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Sql2o;

public class EprodSchoolApp {
    private static final Logger LOG = LoggerFactory.getLogger(EprodSchoolApp.class);
    private Javalin http;

    public static void main(String[] args) {
        try {
            EprodSchoolApp app = new EprodSchoolApp();
            app.start();
        }
        catch (IOException e) {
            LOG.error("Failed to start application", e);
        }
    }

    void start() throws IOException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("MariaDB class not found");
        }

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl( "jdbc:mariadb://127.0.0.1:3306/eprod_school" );
        config.setUsername( "root" );
        config.setPassword( "1298");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.addDataSourceProperty("maximumPoolSize", "15");
        config.addDataSourceProperty("minimumIdle", "2");

        HikariDataSource ds = new HikariDataSource(config);

        Sql2o sql2o = new Sql2o(ds);

        this.http = Javalin.create(cfg -> {
            cfg.addStaticFiles(staticFiles -> {
                staticFiles.precompress = false;
                staticFiles.aliasCheck = null;
                staticFiles.skipFileFunction = req -> false;
            });
        });

        this.http.get("/", ctx -> ctx.result(String.valueOf(System.currentTimeMillis())));

        Sql2oLevelDao levelDao = new Sql2oLevelDao(sql2o);
        JavalinLevelResource levelResource = new JavalinLevelResource(levelDao);
        levelResource.configure(this.http);

        Sql2oStreamDao streamDao = new Sql2oStreamDao(sql2o);
        JavalinStreamResource streamResource = new JavalinStreamResource(streamDao);
        streamResource.configure(this.http);

        Sql2oStudentDao studentDao = new Sql2oStudentDao(sql2o);
        JavalinStudentResource studentResource = new JavalinStudentResource(studentDao);
        studentResource.configure(this.http);

        Sql2oRegistrationDao registrationDao = new Sql2oRegistrationDao(sql2o);
        JavalinRegistrationResource registrationResource = new JavalinRegistrationResource(registrationDao);
        registrationResource.configure(this.http);

        Sql2oUserDao userDao = new Sql2oUserDao(sql2o);
        JavalinUserResource userResource = new JavalinUserResource(userDao);
        userResource.configure(this.http);


        this.http.start();
        LOG.info("Application started");
    }

    void stop() {
        this.http.stop();
        LOG.info("Application stopped");
    }
}

