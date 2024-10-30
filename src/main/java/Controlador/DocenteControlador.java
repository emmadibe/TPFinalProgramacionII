package Controlador;

import Modelos.DocenteModelo;
import Modelos.General;
import Vistas.DocenteVistas;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Docente;
import interfaces.Controladores;

public class DocenteControlador implements Controladores<Docente>
{
    DocenteModelo docenteModelo = new DocenteModelo();
    public void crear()
    {
        if(!this.existeTabla()){ //Si no existe una tabla llamada docentes, crea una.
            docenteModelo.crearTablaBDD();
        }
        Docente docente = new Docente();
        docente = docente.crearInstancia();
        docenteModelo.agregarBDD(docente);
    }

    public boolean existeTabla()
    {
        return General.existeTabla("docentes");
    }

    @Override
    public ArrayListParaTodos<Curso> traer() {//PARA TRAERME TODOS LOS DOCENTES SI EL DOCENTE ES ADMIN.
        return null;
    }

    public  Docente existe()
    {
        Docente docente = DocenteVistas.buscarDocenteVista();
        if(docenteModelo.existeRegistroBDD(docente)){ //Si ya sé que existe el docente con ese email y esa contraseña, me lo traigo.
            docente = DocenteModelo.buscar(docente.getEmail(), docente.getPassword());
        }else{
            docente = null; //Si no existe, docente debe valer null.
        }
        return docente;
    }

    public void eliminar(Docente docente)
    {
        docenteModelo.eliminarBDD(docente);
        System.out.println("Has sido eliminado.");
    }
    public void editar(Docente docente)
    {
        System.out.println("Tus datos actuales: ");
        docente.imprimirUnaInstancia();
        System.out.println("Nuevos datos: ");
        Docente docenteNuevo = docente.crearInstancia();
        docenteNuevo.setId(docente.getId());
        docenteModelo.actualizarBDD(docenteNuevo);
        docente.actualizarSeteo(docenteNuevo);
    }
}
