package Modelos;

import clasesGenerales.Curso;
import clasesGenerales.Estudiante;
import interfaces.Modelos;
import interfaces.ModelosTablasIntermedias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaIntermediaEstudiantexCurso extends General implements ModelosTablasIntermedias<Curso, Estudiante>
{
    @Override
    public void crearTablaIntermedia()
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS tablaInermediaEstudiantesXCursos ("+
                    " id INT AUTO_INCREMENT PRIMARY KEY," +
                    "cursoID INT," +
                    "estudianteID INT," +
                    "CONSTRAINT fk_id_curso FOREIGN KEY (cursoID) REFERENCES cursos(id) ON DELETE CASCADE ON UPDATE CASCADE, " +
                    "CONSTRAINT fk_id_estudiante FOREIGN KEY (estudianteID) REFERENCES estudiantes(id) ON DELETE CASCADE ON UPDATE CASCADE" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Tabla intermedia de Cursos X Alumnos creada con éxito");
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
    }

    @Override
    public void crearregistroTablaIntermedia(Curso curso, Estudiante estudiante)
    {

    }
}
