
package Modelos;

import clasesGenerales.Estudiante;
import interfaces.Modelos;

import java.sql.*;

public class EstudiantesModelo extends General implements Modelos<Estudiante>
{
    public void crearTablaBDD()
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
                    "apellido VARCHAR(100)," +
                    "DNI VARCHAR(100)," +
                    "edad INT)";


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

    @Override
    public boolean existeRegistroBDD(Estudiante estudiante) {
        return false;
    }

    @Override
    public void actualizarBDD(Estudiante estudiante) {

    }

    @Override
    public void agregarBDD(Estudiante estudiante)
    {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO estudiantes(nombre, edad, dni, apellido) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setInt(2, estudiante.getEdad());
            preparedStatement.setString(3, estudiante.getDni());
            preparedStatement.setString(4, estudiante.getApellido());
            preparedStatement.executeUpdate();

            System.out.println("Estudiante nuevo creado con éxito");
        }catch (SQLException e){
            System.out.println("No se pudo crear al estudiante");
        }finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminarBDD(Estudiante estudiante) {

    }

}
