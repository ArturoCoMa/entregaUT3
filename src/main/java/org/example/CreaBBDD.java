package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class CreaBBDD {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String sql = "CREATE DATABASE arturo";

        try(Connection cnn = DriverManager.getConnection(jdbcUrl, "root", "root");
            Statement stmt = cnn.createStatement();
        ) {
            System.out.println("Base de datos creada.");
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
