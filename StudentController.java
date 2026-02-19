package com.myorganisation;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/api/student")
public class StudentController extends HttpServlet {

    private final DBConnection dbConnection = DBConnection.getDBConnectionInstance();
    private final Connection connection = dbConnection.getConnection();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonResponse = null;

        try {
            String sqlQuery = "SELECT *, s.name AS student_name, c.name AS course_name FROM student s LEFT JOIN course c ON s.course = c.id WHERE s.id = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            String studentName = resultSet.getString("student_name");
            String studentPhone = resultSet.getString("phone");
            String studentEmail = resultSet.getString("email");
            String courseId = resultSet.getString("course");
            String courseName = resultSet.getString("course_name");
            String courseFee = resultSet.getString("fee");
            String courseDuration = resultSet.getString("duration");
            String courseDescription = resultSet.getString("description");

            jsonResponse = "{" +
                    "\"name\": " + "\"" + studentName + "\"" + "," +
                    "\"phone\": " + "\"" + studentPhone + "\"" + "," +
                    "\"email\": " + "\"" + studentEmail + "\"" + "," +
                    "\"courseId\": " + "\"" + courseId + "\"" + "," +
                    "\"courseName\": " + "\"" + courseName + "\"" + "," +
                    "\"courseFee\": " + "\"" + courseFee + "\"" + "," +
                    "\"courseDuration\": " + "\"" + courseDuration + "\"" + "," +
                    "\"courseDescription\": " + "\"" + courseDescription + "\"" +
                    "}";

        } catch (SQLException e) {
            System.out.println("An exception occurred during fetching student data: " + e.getMessage());
            jsonResponse = "{" +
                    "\"message\": " + "Data not found!" +
                    "}";
        }

        out.println(jsonResponse);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        long phone = Long.valueOf(req.getParameter("phone"));
        String email = req.getParameter("email");
        long course = Long.valueOf(req.getParameter("course"));

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonResponse = null;

        try {
            String sqlQuery = "INSERT INTO student (name, phone, email, course) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setLong(4, course);

            preparedStatement.executeUpdate();

            jsonResponse = "{\"message\": \"Student registered successfully.\"}";
        } catch (SQLException e) {
            jsonResponse = "{\"message\": \"Student registration failed.\"}";

            System.out.println("An exception occurred: " + e.getMessage());
        }

        out.println(jsonResponse);
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.valueOf(req.getParameter("id"));

        String name = req.getParameter("name");
        long phone = Long.valueOf(req.getParameter("phone"));
        String email = req.getParameter("email");
        long course = Long.valueOf(req.getParameter("course"));

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonResponse = null;

        try {
            String sqlQuery = "UPDATE student SET name = ?, phone = ?, email = ?, course = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setLong(4, course);
            preparedStatement.setLong(5, id);

            preparedStatement.executeUpdate();

            jsonResponse = "{\"message\": \"Student updated successfully.\"}";
        } catch (SQLException e) {
            jsonResponse = "{\"message\": \"Student updation failed.\"}";

            System.out.println("An exception occurred: " + e.getMessage());
        }

        out.println(jsonResponse);
    }

    @Override
    public void doPatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.valueOf(req.getParameter("id"));

        String attribute = req.getParameter("attribute");
        String attributeValue = req.getParameter("value");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonResponse = null;

        try {
            String sqlQuery = "UPDATE student SET " + attribute + " = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, attributeValue);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();

            jsonResponse = "{\"message\": \"Student updated successfully.\"}";
        } catch (SQLException e) {
            jsonResponse = "{\"message\": \"Student updation failed.\"}";

            System.out.println("An exception occurred: " + e.getMessage());
        }

        out.println(jsonResponse);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.valueOf(req.getParameter("id"));

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonResponse = null;

        try {
            String sqlQuery = "DELETE FROM student WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            jsonResponse = "{\"message\": \"Student deleted successfully.\"}";
        } catch (SQLException e) {
            jsonResponse = "{\"message\": \"Student deletion failed.\"}";

            System.out.println("An exception occurred: " + e.getMessage());
        }

        out.println(jsonResponse);
    }

}
