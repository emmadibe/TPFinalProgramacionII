package Controlador;

import Modelos.ExamenesModelo;
import Modelos.General;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Examen;
import interfaces.Controladores;

public class ExamenControlador implements Controladores<Examen>
{
    private int cursoID;

    public ExamenControlador(){}
    public ExamenControlador(int cursoID)
    {
        this.setCursoID(cursoID);
    }
    @Override
    public void crear()
    {
        Examen examen = new Examen();
        ExamenesModelo examenesModelo = new ExamenesModelo();
        if(!existeTabla()){
            examenesModelo.crearTablaBDD();
        }
        examen = examen.crearInstancia();
        examen.setCursoID(this.cursoID);
        examenesModelo.agregarBDD(examen);
    }

    @Override
    public ArrayListParaTodos<Curso> traer() {
        return null;
    }

    @Override
    public Examen existe()
    {
        return null;
    }

    @Override
    public void editar(Examen examen) {

    }

    @Override
    public void eliminar(Examen examen)
    {

    }

    @Override
    public boolean existeTabla()
    {
        return General.existeTabla("examenes");
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
}
