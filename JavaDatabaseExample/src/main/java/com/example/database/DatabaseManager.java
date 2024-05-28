package main.java.com.example.database;

import main.java.com.example.database.models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.lib.DatabaseConnection;

public class DatabaseManager {
    private Connection connection;

    // We get the conn
    public void connect() {
        connection = DatabaseConnection.getConnection();
    }

    // In case we need to disconnect
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // We gotta start the CRUD with the Create ofc
    public void addStudent(Student student) {

        // Store the query on a String
        String query = "INSERT INTO students (id, name, lastName) VALUES (?, ?, ?)";

        // Use a Try-Catch to handle errors in case something goes wrong with the query
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            // We add the values using the prepared statement
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getLastName());

            // Then execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {

            // Catch the excepcion if needed
            e.printStackTrace();
        }
    }

}
