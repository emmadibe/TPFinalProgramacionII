package Modelos;

import interfaces.ModelosTablasIntermedias;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;

public class TablaIntermediaEstudiantesXExamenModelo extends General implements ModelosTablasIntermedias<Integer>
{
    @Override
    public void crearregistroTablaIntermedia(Integer integer, Integer e) {

    }

    @Override
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
                    "CONSTRAINT fk_id_estudiante FOREIGN KEY (estudianteID) REFERENCES estudiantes(id) ON DELETE CASCADE ON UPDATE CASCADE, " +
                    "CONSTRAINT fk_id_examen FOREIGN KEY (examenID) REFERENCES examenes(id) ON DELETE CASCADE ON UPDATE CASCADE" +
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
