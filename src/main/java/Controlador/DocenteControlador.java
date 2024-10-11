package Controlador;

import Modelos.ConsultasGenerales;
import Modelos.DocenteModelo;
import Vistas.DocenteVistas;
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

    public static Docente existeDocente()
    {
        Docente docente = DocenteVistas.buscarDocenteVista();
        if(DocenteModelo.existeDocente(docente.getEmail(), docente.getPassword())){ //Si ya sé que existe el docente con ese email y esa contraseña, me lo traigo.
            docente = DocenteModelo.buscarDocente(docente.getEmail(), docente.getPassword());
        }else{
            docente = null; //Si no existe, docente debe valer null.
        }
        return docente;
    }

    public static void eliminarDocente(Docente docente)
    {
        DocenteModelo.eliminarDocente(docente);
        System.out.println("Has sido eliminado.");
    }
    public static Docente editarDocente(Docente docente)
    {
        System.out.println("Tus datos actuales: ");
        docente.imprimirUnDocente();
        System.out.println("Nuevos datos: ");
        Docente docenteNuevo = Docente.crearDocente();
        docenteNuevo.setId(docente.getId()); //El id debe ser el que ya tenía para poder editarlo.
        DocenteModelo.actualizarDocente(docenteNuevo);
        return  docenteNuevo;
    }
}
