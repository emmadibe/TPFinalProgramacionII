
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class EstudiantesModelo extends General
{


    public static void crearTabla()
    {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS Estudiantes (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(100), " +
                    "edad INT, " +
                    "grado VARCHAR(50))";

            statement.executeUpdate(sql);
            System.out.println("Tabla 'Estudiantes' creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
