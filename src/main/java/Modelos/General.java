package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public abstract class General
{
    public final static String jdbcDriver = "com.mysql.jdbc.Driver";
    public final static String dbURL = "jdbc:mysql://localhost:3306/EscuelasDB"; // Asegúrate de incluir el nombre de la base de datos
    public final static String username = "root";
    public final static String password = "";


}
