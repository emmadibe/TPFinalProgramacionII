package Controlador;

import Excepciones.ValorRepetidoException;
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
        try {
            this.existeRegistro(examen);
            examenesModelo.agregarBDD(examen);
        }catch (ValorRepetidoException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayListParaTodos<Curso> traer() {
        return null;
    }

    public boolean existeRegistro(Examen examen) throws ValorRepetidoException
    {
        ExamenesModelo examenesModelo = new ExamenesModelo();
        Boolean existe = examenesModelo.existeRegistroBDD(examen);
        if(!existe){
            return false;
        }else{
            throw new ValorRepetidoException("Ya existe un examen con ese nombre en el curso " + examen.getCursoID());
        }
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
