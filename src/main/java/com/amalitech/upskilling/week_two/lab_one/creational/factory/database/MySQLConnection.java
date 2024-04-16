package com.amalitech.upskilling.week_two.lab_one.creational.factory.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements DatabaseConnection {
    private final String url;
    private final String username;
    private final String password;

    public MySQLConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
