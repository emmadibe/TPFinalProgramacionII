package Controlador;

import Modelos.CursoModelo;
import Modelos.General;
import clasesGenerales.Curso;
import clasesGenerales.CursoArrayList;
import clasesGenerales.Docente;
import interfaces.Controladores;

import java.awt.geom.RectangularShape;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public void traer() //PARA TRAERME TOS LOS CURSOS PERTENECIENTES AL DOCENTE.
    {
        CursoArrayList cursoArrayList = new CursoArrayList(100);
        cursoArrayList = cursoModelo.traerTodos(this.getDocenteID());

    }

    @Override
    public Curso existe() {
        return null;
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
