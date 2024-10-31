package Modelos;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Estudiante;
import clasesGenerales.Examen;
import interfaces.Modelos;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ConcurrentModificationException;

public class ExamenesModelo extends General implements Modelos<Examen>
{
    @Override
    public ArrayListParaTodos traerTodos(Integer idCurso) {
        return null;
    }

    @Override
    public void eliminarBDD(Examen examen) {

    }

    @Override
    public void crearTablaBDD()
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS examenes ("+
                    " id INT AUTO_INCREMENT PRIMARY KEY," +
                    "cursoID INT," +
                    "numeroExamen INT," +

                    "CONSTRAINT fk_id_cursoParaExamen FOREIGN KEY (cursoID) REFERENCES cursos(id) ON DELETE CASCADE ON UPDATE CASCADE" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Tabla exámenes creada con éxito.");
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
    public void agregarBDD(Examen examen) {

    }

    @Override
    public boolean existeRegistroBDD(Examen examen) {
        return false;
    }

    @Override
    public void actualizarBDD(Examen examen) {

    }
}
