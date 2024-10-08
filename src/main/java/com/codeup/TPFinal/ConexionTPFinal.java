package com.codeup.TPFinal;

import Modelos.General;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionTPFinal extends General
{
        public static Connection getConnection()
        {
            Connection connection = null;
            try {
                Class.forName(getJdbcDriver());
                connection = DriverManager.getConnection(dbURL, username, password);
                String sql = "CREATE DATABASE IF NOT EXISTS tpFinalProgramacionII";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Base de datos creada exitosamente.");
                General.setDbURL("jdbc:mysql://localhost:3306/tpFinalProgramacionII"); //Luego de crear la base de datos, seteo el valor de la variable dbURL para que contenga el nombre de la base de datos. Esto es necesario para realizar cualquier consulta, ya que necesitan saber a qué base de datos estoy haciendo referencia.
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
}
