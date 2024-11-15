package Controlador;

import Modelos.General;
import Modelos.TablaIntermediaEstudiantesXExamenModelo;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Estudiante;
import clasesGenerales.TablaIntermediaEstudiantesXExamen;
import interfaces.Controladores;

import java.util.ArrayList;

public class TablaIntermediaEstudiantesXExamenControlador implements Controladores<TablaIntermediaEstudiantesXExamen>
{

    private int examenID;
    private int estudianteID;
    private int cursoID;
    private int nota;

    TablaIntermediaEstudiantesXExamenModelo tablaIntermediaEstudiantesXExamenModelo = new TablaIntermediaEstudiantesXExamenModelo();
    public  TablaIntermediaEstudiantesXExamenControlador(int examenID, int cursoID)
    {
        this.setExamenID(examenID);
        this.setCursoID(cursoID);
    }
    public TablaIntermediaEstudiantesXExamenControlador(int examenID, int estudianteID, int cursoID)
    {
        this.setEstudianteID(estudianteID);
        this.setExamenID(examenID);
        this.setCursoID(cursoID);
    }

    @Override
    public TablaIntermediaEstudiantesXExamen existe() {
        return null;
    }

    @Override
    public boolean existeTabla() {
        return General.existeTabla("TablaIntermediaEstudiantesXExamen");
    }

    @Override
    public void crear()
    {
        if(!existeTabla()){
            tablaIntermediaEstudiantesXExamenModelo.crearTablaIntermedia();
        }
        EstudianteControlador estudianteControlador = new EstudianteControlador(this.getCursoID());
        ArrayListParaTodos<Estudiante> arrayListParaTodos = new ArrayListParaTodos<Estudiante>();
        arrayListParaTodos = estudianteControlador.traer(); //Tengo a todos los alumnos del cursoID al que pertenece el examen.
        int tamanioArrayList = arrayListParaTodos.tamanio();
        int i = 0;
        arrayListParaTodos.imprimirTodos();
        do{
            System.out.println("Estudiante ID: " + arrayListParaTodos.retornarElementoPorPosicion(i).getId());
            tablaIntermediaEstudiantesXExamenModelo.crearregistroTablaIntermedia(this.getExamenID(), arrayListParaTodos.retornarElementoPorPosicion(i).getId(), arrayListParaTodos.retornarElementoPorPosicion(i).getCursoId());
            i ++;
        }while(i < tamanioArrayList);
    }

    @Override
    public void editar(TablaIntermediaEstudiantesXExamen tablaIntermediaEstudiantesXExamen) {

    }

    @Override
    public ArrayListParaTodos traer() {
        return null;
    }

    @Override
    public void eliminar(TablaIntermediaEstudiantesXExamen tablaIntermediaEstudiantesXExamen) {

    }

    public int getExamenID() {
        return examenID;
    }

    public void setExamenID(int examenID) {
        this.examenID = examenID;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
}