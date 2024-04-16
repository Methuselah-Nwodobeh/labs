package com.amalitech.upskilling.week_two.lab_one.creational.factory.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    Connection getConnection() throws SQLException;
}
