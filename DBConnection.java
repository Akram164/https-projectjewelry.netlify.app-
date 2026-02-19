package com.myorganisation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbConnectionInstance = null;

    private Connection connection = null;

    private DBConnection() {
        //JDBC
        final String DB_URL = "jdbc:mysql://localhost:3306/sms?createDatabaseIfNotExist=true";
        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Database connected successfully!");

            String studentTableSqlQuery = "CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, phone BIGINT UNIQUE, email VARCHAR(255) UNIQUE, course INT)";
            String courseTableSqlQuery = "CREATE TABLE IF NOT EXISTS course (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, fee FLOAT, duration FLOAT)";

            Statement statement = connection.createStatement();
            statement.execute(studentTableSqlQuery);
            statement.execute(courseTableSqlQuery);
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println("An exception occurred at DB connection: " + e.getMessage());
        }
    }

    public static DBConnection getDBConnectionInstance() {
        if(dbConnectionInstance == null) {
            dbConnectionInstance = new DBConnection();
        }

        return dbConnectionInstance;
    }

    public Connection getConnection() {
        return connection;
    }

}
