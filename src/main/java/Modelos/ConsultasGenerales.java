package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConsultasGenerales extends General
{
    public static boolean  ExisteTabla(String nombreTabla) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean existe = false;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();


            String sql = "SELECT COUNT(*) FROM information_schema.tables " +
                    "WHERE table_schema = 'tpFinalProgramacionII' AND table_name = '" + nombreTabla + "'"; //EL nombre de la tabla debe estar entre comillas simples.

            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                existe = count > 0; // Si el conteo es mayor que 0, la tabla existe; por ende, existe almacenará el valor true.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return existe;
    }

}
