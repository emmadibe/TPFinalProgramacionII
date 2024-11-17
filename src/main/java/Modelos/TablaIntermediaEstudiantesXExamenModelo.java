package Modelos;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.TablaIntermediaEstudiantesXExamen;
import interfaces.ModelosTablasIntermedias;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class TablaIntermediaEstudiantesXExamenModelo extends General
{

    public void crearregistroTablaIntermedia(Integer examenID, Integer estudianteID, Integer nota)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO tablaIntermediaEstudiantesXExamen(examenID, estudianteID, nota) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, examenID);
            preparedStatement.setInt(2, estudianteID);
            preparedStatement.setInt(3, nota);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void actualizar(int nota, int registroID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE tablaintermediaestudiantesxexamen SET nota = ? WHERE id = ?";

        try {

            connection = DriverManager.getConnection(dbURL, username, password);


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nota);
            preparedStatement.setInt(2, registroID);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Nota subida correctamente.");
            } else {
                System.out.println("No se encontró el estudiante con ID: " + registroID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayListParaTodos<TablaIntermediaEstudiantesXExamen> traerTodo(int examenID) //Me traigo todos los registros en donde coincidan con el id del examen
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayListParaTodos<TablaIntermediaEstudiantesXExamen> arrayListParaTodos = new ArrayListParaTodos<TablaIntermediaEstudiantesXExamen>(100);
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT t.id, t.examenID, t.estudianteID, t.nota, CONCAT(e.nombre, ' ', e.apellido) AS nombreYApellido, e.dni FROM tablaintermediaestudiantesxexamen t INNER JOIN estudiantes e ON t.estudianteID = e.id WHERE t.examenID = " + examenID;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int estudianteID = resultSet.getInt("estudianteID");
                int nota = resultSet.getInt("nota");
                String nombreYApellidoAlumno = resultSet.getString("nombreYApellido");
                String dniAlumno = resultSet.getString("DNI");
                TablaIntermediaEstudiantesXExamen tI = new TablaIntermediaEstudiantesXExamen(id, examenID, estudianteID, nota, nombreYApellidoAlumno, dniAlumno);
                arrayListParaTodos.agregar(tI);
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
        return arrayListParaTodos;
    }

    public void crearTablaIntermedia()
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS tablaIntermediaEstudiantesXExamen ("+
                    " id INT AUTO_INCREMENT PRIMARY KEY," +
                    "examenID INT," +
                    "nota INT," +
                    "estudianteID INT," +
                    "CONSTRAINT fk_id_estudiantes FOREIGN KEY (estudianteID) REFERENCES estudiantes(id) ON DELETE CASCADE ON UPDATE CASCADE, " +
                    "CONSTRAINT fk_id_examenes FOREIGN KEY (examenID) REFERENCES examenes(id) ON DELETE CASCADE ON UPDATE CASCADE" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Tabla Intermedia de Estudiantes x Examenes creada con exito.");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) connection.close();
                if(statement != null) statement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
