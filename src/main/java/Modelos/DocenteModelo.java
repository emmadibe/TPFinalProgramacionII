package Modelos;

import clasesGenerales.Docente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DocenteModelo extends General
{

    public static void crearTabla()
    {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS docentes (" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY," +
                    "    nombre VARCHAR(100)," +
                    "    apellido VARCHAR(100)," +
                    "    edad INT," +
                    "    email VARCHAR(50)," +
                    "    rama VARCHAR(50)" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Tabla docentes creada con exito");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void agregarDocente(Docente docente)
    {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO docentes(nombre, apellido, edad, email, rama) VALUES ('" +
                    docente.getNombre().replace("'", "''") + "', '" +
                    docente.getApellido().replace("'", "''") + "', " +
                    docente.getEdad() + ", '" +
                    docente.getEmail().replace("'", "''") + "', '" +
                    docente.getRama().replace("'", "''") + "')";

            statement.executeUpdate(sql);
            System.out.println("Docente creado con éxito!");
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement != null) statement.close();
                if (connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static boolean existeDocente(String nombre, String password)
    {
        Connection connection = null;
        Statement statement = null;
        boolean existe = false;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM docentes WHERE nombre = '" + nombre + "' and password = '" + password + "'";
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return existe;

    }
}



