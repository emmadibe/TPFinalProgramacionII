package Modelos;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Examen;
import clasesGenerales.MostrarTodo;
import interfaces.Modelos;

import java.sql.*;
import java.util.Objects;
import java.util.Vector;

public class MostrarTodoModelo extends General
{
    public static Vector<Vector<Object>> getData(Integer cursoID) {
        Vector<Vector<Object>> data = new Vector<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT es.id AS estudianteID, es.nombre, ex.id AS examenID, " +
                "numeroExamen, ex.nombre AS nombreExamen, ti.nota " +
                "FROM examenes ex " +
                "INNER JOIN tablaintermediaestudiantesxexamen ti ON ti.examenID = ex.id " +
                "INNER JOIN estudiantes es ON es.id = ti.estudianteID " +
                "WHERE ex.cursoID = ?";


            try{
                connection = DriverManager.getConnection(dbURL, username, password);
                statement = connection.createStatement();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, cursoID);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(resultSet.getInt("estudianteID"));
                    row.add(resultSet.getString("nombre"));
                    row.add(resultSet.getInt("examenID"));
                    row.add(resultSet.getInt("numeroExamen"));
                    row.add(resultSet.getString("nombreExamen"));
                    row.add(resultSet.getInt("nota"));
                    data.add(row);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    if(connection != null) connection.close();
                    if(statement != null) statement.close();
                    if(resultSet != null) resultSet.close();
                    if(preparedStatement != null) preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return data;
        }

    }


