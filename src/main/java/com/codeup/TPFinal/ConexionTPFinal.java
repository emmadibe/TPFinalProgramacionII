package com.codeup.TPFinal;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionTPFinal
{
        private static String jdbcDriver = "com.mysql.jdbc.Driver";
        private static String dbURL = "jdbc:mysql://localhost:3306/";
        private static String username = "root";
        private static String password = "";

        public static Connection getConnection()
        {
            Connection connection = null;
            try {
                Class.forName(jdbcDriver);
                connection = DriverManager.getConnection(dbURL, username, password);
                String sql = "CREATE DATABASE IF NOT EXISTS EscuelasDB";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Base de datos creada exitosamente.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
}
