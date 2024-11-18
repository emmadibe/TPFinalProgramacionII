package Modelos;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Examen;
import clasesGenerales.MostrarTodo;
import interfaces.Modelos;

import java.sql.*;

public class MostrarTodoModelo extends General
{
    public ArrayListParaTodos<MostrarTodo> traerTodos(Integer cursoID)
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayListParaTodos<MostrarTodo> array = new ArrayListParaTodos<MostrarTodo>(10);
        String sql = "SELECT es.id AS estudianteID, es.nombre, ex.id AS examenID, " +
                "numeroExamen, ex.nombre AS nombreExamen, ti.nota " +
                "FROM examenes ex " +
                "INNER JOIN tablaintermediaestudiantesxexamen ti ON ti.examenID = ex.id " +
                "INNER JOIN estudiantes es ON es.id = ti.estudianteID " +
                "WHERE ex.cursoID = " + cursoID;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int estudianteID = resultSet.getInt("estudianteID");
                int examenID = resultSet.getInt("examenID");
                String nombreEstudiante = resultSet.getString("nombre");
                int nroExamen = resultSet.getInt("numeroExamen");
                String nombreExamen = resultSet.getString("nombreExamen");
                int nota = resultSet.getInt("nota");
                MostrarTodo mostrarTodo = new MostrarTodo(estudianteID, nombreEstudiante, examenID, nroExamen, nombreExamen, nota);
                array.agregar(mostrarTodo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return array;
    }

}
