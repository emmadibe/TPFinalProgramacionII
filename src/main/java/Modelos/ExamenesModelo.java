package Modelos;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Estudiante;
import clasesGenerales.Examen;
import interfaces.Modelos;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
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
            String sql = "CREATE TABLE IF NOT EXISTS examenes (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "cursoID INT, " +
                    "nombre VARCHAR(100), " +
                    "numeroExamen INT, " +
                    "CONSTRAINT fk_id_cursoParaExamen FOREIGN KEY (cursoID) REFERENCES cursos(id) ON DELETE CASCADE ON UPDATE CASCADE, " +
                    "UNIQUE (cursoID, nombre)" + //Para que esa combinación no se repita.
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
    public void agregarBDD(Examen examen)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO examenes(cursoID, numeroExamen, nombre) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, examen.getCursoID());
            pstmt.setInt(2, examen.getNumeroDeExamen());
            pstmt.setString(3, examen.getNombre());
            pstmt.executeUpdate();
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
    public boolean existeRegistroBDD(Examen examen)
    {
        String nombre = examen.getNombre();
        int cursoID = examen.getCursoID();
        Connection connection = null;
        Statement statement = null;
        boolean existe = true;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM examenes WHERE nombre = '" + nombre + "' AND cursoID = '" + cursoID +"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(!resultSet.next()){
                existe = false;
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
        return existe;
    }

    @Override
    public void actualizarBDD(Examen examen) {

    }
}
