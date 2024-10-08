package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public abstract class General
{
    protected static String jdbcDriver = "com.mysql.jdbc.Driver";
    protected static String dbURL = "jdbc:mysql://localhost:3306/"; //En un principio, no pongo el nombre de la base de datos después del último slash(/). Pues, sino me va a tirar un error la primera vez que haga el programa porque aun no existe la base de datos. Lo que voy a hacer, primero, es crear la base de datos y, luego de crearla, seteo este atributo para agregarle el nombre.
    protected static String username = "root";
    protected static String password = "";

    public static String getJdbcDriver() {
        return jdbcDriver;
    }

    public static String getDbURL() {
        return dbURL;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setJdbcDriver(String jdbcDriver) {
        General.jdbcDriver = jdbcDriver;
    }

    public static void setDbURL(String dbURL) {
        General.dbURL = dbURL;
    }

    public static void setUsername(String username) {
        General.username = username;
    }

    public static void setPassword(String password) {
        General.password = password;
    }
}
