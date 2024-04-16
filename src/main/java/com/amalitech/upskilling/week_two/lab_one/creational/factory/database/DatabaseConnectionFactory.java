package com.amalitech.upskilling.week_two.lab_one.creational.factory.database;

public class DatabaseConnectionFactory {

    private DatabaseConnectionFactory() {}

    public static DatabaseConnection createConnection(String databaseType, String url, String username, String password) {
        return switch (databaseType.toLowerCase()) {
            case "mysql" -> new MySQLConnection(url, username, password);
            case "postgresql" -> new PostgreSQLConnection(url, username, password);
            default -> throw new IllegalArgumentException("Unsupported database type: " + databaseType);
        };
    }
}
