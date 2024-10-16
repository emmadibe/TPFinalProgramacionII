package Controlador;

import Modelos.CursoModelo;
import Modelos.General;
import clasesGenerales.Curso;
import clasesGenerales.Docente;
import interfaces.Controladores;

public class CursoControlador implements Controladores<Curso>
{
    CursoModelo cursoModelo = new CursoModelo();
    public void crear() //Creo una instancia de la clase Curso, y lo guardo en la BDD.
    {
        Curso curso = new Curso();
        CursoControlador cursoControlador  = new CursoControlador();
        if(!cursoControlador.existeTabla()){ //Si no existe la tabla en la bdd, la crea
            cursoModelo.crearTablaBDD();
        }
        curso = curso.crearInstancia();
        cursoModelo.agregarBDD(curso);
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
}
