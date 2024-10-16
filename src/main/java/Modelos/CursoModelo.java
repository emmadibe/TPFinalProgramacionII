package Modelos;

import clasesGenerales.Curso;
import interfaces.Modelos;

import java.sql.*;
import java.text.CompactNumberFormat;

public class CursoModelo extends General implements Modelos<Curso>
{
    public void crearTablaBDD()
    {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS cursos ("+
                                                        " id INT AUTO_INCREMENT PRIMARY KEY," +
                                                        "nombre VARCHAR(100)," +
                                                        "cantAlumnos INT," +
                                                        "escuela VARCHAR(100)," +
                                                        "materia VARCHAR(100)," +
"docenteID INT," +
                                                        "CONSTRAINT fk_id_docente FOREIGN KEY (docenteID) REFERENCES docentes(id) ON DELETE CASCADE ON UPDATE CASCADE" +
                                                            ")";
            statement.executeUpdate(sql);
            System.out.println("Tabla cursos creada con éxito");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean existeRegistroBDD(Curso curso) {
        String nombre = curso.getNombre();
        int docenteId = curso.getDocenteID();
        Connection connection = null;
        Statement statement = null;
        boolean existe = true;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM cursos WHERE nombre = '" + nombre + "' and docenteID = '" + docenteId + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(!resultSet.next()){
                existe = false;
            }
        }catch (SQLException e){
           e.printStackTrace();
        }finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return existe;
    }

    @Override
    public void actualizarBDD(Curso curso) {

    }

    @Override
    public void agregarBDD(Curso curso)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "INSERT into cursos(nombre, cantAlumnos, escuela, materia)" +
                    "VALUES ('" +
                            curso.getNombre().replace("'", "''") + "', '" +
                            curso.getCantidadAlumnos() + "', '" +
                            curso.getEscuela().replace("'", "''") + "', '" +
                            curso.getMateria().replace("'", "''") + "', ";
            statement.executeUpdate(sql);
            System.out.println("Curso nuevo creado con éxito!!");
        }catch (SQLException e){
            System.out.println("ERROR!");
        }finally {
            try {
                if(statement != null)statement.close();
                if(connection != null)connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminarBDD(Curso curso) {

    }
}
