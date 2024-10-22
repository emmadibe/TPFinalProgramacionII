package Controlador;

import Modelos.EstudiantesModelo;
import Modelos.General;
import clasesGenerales.Curso;
import clasesGenerales.Estudiante;
import interfaces.Controladores;

public class EstudianteControlador implements Controladores<Estudiante>
{
    private int cursoID;
    public EstudianteControlador(int cursoID)
    {
        this.setCursoID(cursoID);
    }

    EstudiantesModelo estudiantesModelo = new EstudiantesModelo();
    @Override
    public Estudiante existe() {
        return null;
    }

    @Override
    public Estudiante traer() {
        return null;
    }

    @Override
    public boolean existeTabla() {
        return General.existeTabla("estudiantes");
    }

    @Override
    public void crear()//Creo una instancia de la clase Estudiante y lo guardo en la BDD
    {
        Estudiante estudiante = new Estudiante();
        if(!this.existeTabla()){
            estudiantesModelo.crearTablaBDD();
        }
        estudiante = estudiante.crearInstancia();
        estudiantesModelo.agregarBDD(estudiante);
    }

    @Override
    public void editar(Estudiante estudiante) {

    }

    @Override
    public void eliminar(Estudiante estudiante) {

    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
}
