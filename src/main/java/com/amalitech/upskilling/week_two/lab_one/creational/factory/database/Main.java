package com.amalitech.upskilling.week_two.lab_one.creational.factory.database;

import com.amalitech.upskilling.OutPut;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
           String databaseType = "postgresql";
        String url = "";
        String username = "";
        String password = "";

        // Create a MySQL database connection
        DatabaseConnection connection = DatabaseConnectionFactory.createConnection(databaseType, url, username, password);
        Connection dbConnection = connection.getConnection();

        // Use the database connection,
        // For example, execute SQL queries, perform database operations, etc.
//        query to the number of users in accounts_users table
        DatabaseMetaData metaData = dbConnection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
        OutPut.printColoredTextBlock("Database Schema:", OutPut.Colors.BLUE);
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            OutPut.printColoredTextBlock("Table: " + tableName, OutPut.Colors.CYAN);
        }


        // Close the database connection when done
        dbConnection.close();
    }
}
