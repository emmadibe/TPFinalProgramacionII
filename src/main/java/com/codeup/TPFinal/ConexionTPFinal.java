package com.codeup.TPFinal;

import java.sql.*;

public class ConexionTPFinal
{
    public static void main(String args[])
    {
        String jdbcDriver = "com.mysql.cj.jdbc.Driver"; // Controlador JDBC
        String url = "TPFinal:mysql://localhost:3306/";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
        }catch(SQLException e){

        }
    }
}
