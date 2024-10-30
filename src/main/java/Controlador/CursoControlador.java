package Controlador;

import Modelos.CursoModelo;
import Modelos.General;
import Vistas.CursoVistas;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import interfaces.Controladores;

public class CursoControlador implements Controladores<Curso>
{

    private int docenteID; //Le pongo este atributo  a la clase CursoControlador para poder saber el valor de docenteID a la hora de crear un registro nuevo de la tabla Cursos.

    public CursoControlador(int docenteID)
    {
        this.setDocenteID(docenteID);
    }
    public CursoControlador(){}

    CursoModelo cursoModelo = new CursoModelo();
    public void crear() //Creo una instancia de la clase Curso, y lo guardo en la BDD.
    {
        Curso curso = new Curso();
        if(!this.existeTabla()){ //Si no existe la tabla en la bdd, la crea
            cursoModelo.crearTablaBDD();
        }
        curso = curso.crearInstancia();
        curso.setDocenteID(this.getDocenteID());
        cursoModelo.agregarBDD(curso);
    }

    public void entrarCurso(int idCUrso)
    {

    }

    @Override
    public ArrayListParaTodos traer() //PARA TRAERME TOS LOS CURSOS PERTENECIENTES AL DOCENTE.
    {
        ArrayListParaTodos<Curso> cursoArrayList = new ArrayListParaTodos<Curso>(100);
        cursoArrayList = cursoModelo.traerTodos(this.getDocenteID());
        return cursoArrayList;
    }

    @Override
    public Curso existe()
    {
        Curso curso = null; //Si no existe el elemento en el arrayList o directamente el arrayList está vacío, retornará null.
        int idCursoABuscar = CursoVistas.buscarCursoVista(); //Pido el id del curso a buscar.
        ArrayListParaTodos<Curso> cursoArrayList = new ArrayListParaTodos<Curso>(100);
        cursoArrayList = cursoModelo.traerTodos(this.getDocenteID()); //Me traigo todos los cursos de la bdd que pertenecen al docente y los guardo en un arrayList.
        if(!cursoArrayList.estaVacio()){ //Compruebo que el arrayListo no esté vacío.
            if(cursoArrayList.existeIdEnArrayList(idCursoABuscar)){//Compruebo que exista el id del curso a buscar
                int posicion = cursoArrayList.traerPosicionDelElementoEnElArrayListPorId(idCursoABuscar);
                curso = cursoArrayList.traerElementoPorPosicion(posicion);
            }
        }
        return curso;
    }

    @Override
    public void editar(Curso curso) {

    }

    @Override
    public void eliminar(Curso curso) {

    }

    @Override
    public boolean existeTabla() {
        return General.existeTabla("cursos");
    }

    public int getDocenteID() {
        return docenteID;
    }

    public void setDocenteID(int docenteID) {
        this.docenteID = docenteID;
    }
}
