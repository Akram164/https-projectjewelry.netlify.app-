package com.myorganisation;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/api/all-student")
public class AllStudentController extends HttpServlet {
    private final DBConnection dbConnection = DBConnection.getDBConnectionInstance();
    private final Connection connection = dbConnection.getConnection();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        StringBuilder jsonResponse = new StringBuilder();
        jsonResponse.append("[");

        try {
            String sqlQuery = "SELECT * FROM student";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                String studentId = resultSet.getString("id");
                String studentName = resultSet.getString("name");
                String studentPhone = resultSet.getString("phone");
                String studentEmail = resultSet.getString("email");
                String courseId = resultSet.getString("course");

                String student = "{" +
                        "\"id\": " + studentId + "," +
                        "\"name\": " + "\"" + studentName + "\"" + "," +
                        "\"phone\": " + "\"" + studentPhone + "\"" + "," +
                        "\"email\": " + "\"" + studentEmail + "\"" + "," +
                        "\"courseId\": " + "\"" + courseId + "\"" +
                        "}";

                jsonResponse.append(student).append(",");

            }

            if(jsonResponse.charAt(jsonResponse.length()-1) == ',') {
                jsonResponse.deleteCharAt(jsonResponse.length()-1);
            }

            jsonResponse.append("]");

        } catch (SQLException e) {
            System.out.println("An exception occurred during fetching student data: " + e.getMessage());
            jsonResponse.setLength(0);

            String output = "{" +
                    "\"message\": " + "Data not found!" +
                    "}";

            jsonResponse.append(output);
        }

        out.println(jsonResponse);
    }
}

