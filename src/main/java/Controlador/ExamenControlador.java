package Controlador;

import Excepciones.NoExisteIdException;
import Excepciones.ValorRepetidoException;
import Modelos.ExamenesModelo;
import Modelos.General;
import Vistas.ExamenVistas;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Examen;
import interfaces.Controladores;

public class ExamenControlador implements Controladores<Examen>
{
    private int cursoID;

    public ExamenControlador(){}
    public ExamenVistas examenVistas = new ExamenVistas();
    ExamenesModelo examenesModelo = new ExamenesModelo();
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
    public ArrayListParaTodos<Examen> traer()
    {
        ArrayListParaTodos<Examen> arrayExamenes = new ArrayListParaTodos<Examen>(100);
        ExamenesModelo examenesModelo = new ExamenesModelo();
        if(this.existeTabla()){
            arrayExamenes = examenesModelo.traerTodos(this.getCursoID());
        }
        return arrayExamenes;
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
        Examen examen = null; //Si no exste el elemento en el arrayList o direcatemente el arrayList está vacío, retornará null.
        int idExamen = examenVistas.buscarExamenVista();
        ArrayListParaTodos<Examen> arrayListExamen = new ArrayListParaTodos<Examen>(100);
        arrayListExamen = examenesModelo.traerTodos(this.getCursoID());
        if(!arrayListExamen.estaVacio()) {
            try {
                arrayListExamen.existeIdEnArrayList(idExamen); //Compruebo que exista el id. De no existir, me tira la excepción creada por mi llamada NoExisteIdException.
                int posicion = arrayListExamen.traerPosicionDelElementoEnElArrayListPorId(idExamen);
                examen = arrayListExamen.traerElementoPorPosicion(posicion);
            } catch (NoExisteIdException e) {
                e.printStackTrace();
            }
        }
        return examen;
    }

    public int retornarUltimoid()
    {
        return examenesModelo.retornarUltimoID();
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
