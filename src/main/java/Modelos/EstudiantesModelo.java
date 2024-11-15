
package Modelos;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Estudiante;
import interfaces.Modelos;
import org.hibernate.exception.ConstraintViolationException;
import java.sql.*;

public class EstudiantesModelo extends General implements Modelos<Estudiante>
{
    public void crearTablaBDD() {
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
                    "DNI VARCHAR(100) UNIQUE," + //Para poder identificar que el estudiante no sea repetido.
                    "edad INT)";


            statement.executeUpdate(sql);
            System.out.println("Tabla 'Estudiantes' creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
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
    public ArrayListParaTodos<Estudiante> traerTodos(Integer idCurso) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayListParaTodos<Estudiante> estudianteArrayListParaTodos = new ArrayListParaTodos<Estudiante>(100);
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT e.* " +
                    "FROM estudiantes e " +
                    "JOIN tablaintermediaestudiantesxcursos ec ON e.id = ec.estudianteID " +
                    "WHERE ec.cursoID = " + idCurso + ";";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String dni = resultSet.getString("DNI");
                int edad = resultSet.getInt("edad");
                Estudiante estudiante = new Estudiante(id, dni, nombre, apellido, edad);
                estudianteArrayListParaTodos.agregar(estudiante);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return estudianteArrayListParaTodos;
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
        }catch (ConstraintViolationException e){ //Excepción por si el usuario ingresa un valor repetido en un campo con la constrcciion UNIQUE. DNI tiene esa constriccion.
            System.out.println("Ya existe un usuario con ese DNI.");
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

    public int getIDULTIMOREGISTROBDD()
    {
        Connection connection = null;
        Statement statement = null;
        int idEstudiante = -1;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT MAX(id) AS ultimoID FROM estudiantes";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                idEstudiante = resultSet.getInt("ultimoID");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return idEstudiante;
    }
}
