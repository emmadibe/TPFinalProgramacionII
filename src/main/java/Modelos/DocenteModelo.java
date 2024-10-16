package Modelos;

import clasesGenerales.Docente;
import interfaces.Modelos;

import javax.print.Doc;
import java.sql.*;

public class DocenteModelo extends General implements Modelos<Docente>
{

    public void crearTablaBDD()
    {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS docentes (" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY," +
                    "    nombre VARCHAR(100)," +
                    "    apellido VARCHAR(100)," +
                    "    edad INT," +
                    "    email VARCHAR(50) UNIQUE," +
                    "    rama VARCHAR(50)," +
                    "    password VARCHAR(59)" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Tabla docentes creada con exito");
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
    }

    public void agregarBDD(Docente docente)
    {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO docentes(nombre, apellido, edad, email, rama, password) VALUES ('" +
                    docente.getNombre().replace("'", "''") + "', '" +
                    docente.getApellido().replace("'", "''") + "', " +
                    docente.getEdad() + ", '" +
                    docente.getEmail().replace("'", "''") + "', '" +
                    docente.getRamaDocente().toString().replace("'", "''") + "', '" +
                    docente.getPassword().replace("'","''") + "')";

            statement.executeUpdate(sql);
            System.out.println("Docente creado con éxito!");
        }catch (SQLException e) {
            if(e.getSQLState().equals("23000")){ //La excepción "23000" indica un valor unique duplicado.
                System.out.println("El email ingresado ya se encuewntra registrado.");
            }else {
                e.printStackTrace();
            }
        } finally {
            try {
                if(statement != null) statement.close();
                if (connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static Docente buscar(String email, String pass)
    {
        Connection connection = null;
        Statement statement = null;
        Docente docente = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM docentes WHERE email = '" + email + "' and password = '" + pass + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String rama = resultSet.getString("rama").toLowerCase(); //Hago el lowerCase para que aparezca en minuscula y asi identificar la rama.
                int edad = resultSet.getInt("edad");
                docente = new Docente(id, nombre, apellido, edad, email, rama, pass);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) statement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return docente;
    }

    public boolean existeRegistroBDD(Docente docente)
    {
        String email = docente.getEmail();
        String pass = docente.getPassword();
        Connection connection = null;
        Statement statement = null;
        boolean existe = true;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM docentes WHERE email = '" + email + "' and password = '" + pass + "'";
            ResultSet resultSet =  statement.executeQuery(sql);
            if(!resultSet.next()){
                existe = false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return existe;
    }

    public void actualizarBDD(Docente docente)
    {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();

            String sql = "UPDATE docentes SET nombre = '" + docente.getNombre() + "', apellido = '" + docente.getApellido() + "', edad = " + docente.getEdad() + ", rama = '" + docente.getRamaDocente() + "', email = '" + docente.getEmail() + "', password = '" + docente.getPassword() + "' WHERE id = " + docente.getId();
            statement.executeUpdate(sql);
            System.out.println("Docente actualizado con exito.");
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

    public void eliminarBDD(Docente docente)
    {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String sql = "DELETE FROM docentes WHERE id = " +  docente.getId();
            statement.executeUpdate(sql);
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
}



