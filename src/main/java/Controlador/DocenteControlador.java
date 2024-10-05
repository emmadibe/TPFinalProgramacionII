package Controlador;

import Modelos.ConsultasGenerales;
import Modelos.DocenteModelo;
import clasesGenerales.Docente;
import com.codeup.TPFinal.ConexionTPFinal;
import Modelos.DocenteModelo;

import java.sql.Connection;
import java.sql.Statement;

public class DocenteControlador
{
    public static void crearDocente()
    {
        if(!DocenteControlador.existeTablaDocente()){ //Si no existe una tabla llamada docentes, crea una.
            DocenteModelo.crearTabla();
        }
        Docente docente = Docente.crearDocente();
        DocenteModelo.agregarDocente(docente);
    }

    public static boolean existeTablaDocente()
    {
        return ConsultasGenerales.ExisteTabla("docentes");
    }

    public void eliminarDocente()
    {

    }
    public void editarDocente()
    {

    }
    public void buscarDocente()
    {

    }

}
