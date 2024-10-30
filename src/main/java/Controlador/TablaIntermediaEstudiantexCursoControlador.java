package Controlador;

import Modelos.General;
import Modelos.TablaIntermediaEstudiantexCursoModelo;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.TablaIntermedioEstudiantexCurso;
import interfaces.Controladores;

public class TablaIntermediaEstudiantexCursoControlador implements Controladores<TablaIntermedioEstudiantexCurso>
{
    private int id;
    private int idCurso;
    private int idEstudiante;

    TablaIntermediaEstudiantexCursoModelo tablaIntermediaEstudiantexCursoModelo = new TablaIntermediaEstudiantexCursoModelo();

    public TablaIntermediaEstudiantexCursoControlador(int idCurso, int idEstudiante)
    {
        this.setIdCurso(idCurso);
        this.setIdEstudiante(idEstudiante);
    }

    @Override
    public TablaIntermedioEstudiantexCurso existe() {
        return null;
    }

    @Override
    public void eliminar(TablaIntermedioEstudiantexCurso tablaIntermedioEstudiantexCurso) {

    }

    @Override
    public void editar(TablaIntermedioEstudiantexCurso tablaIntermedioEstudiantexCurso) {

    }

    @Override
    public ArrayListParaTodos<Curso> traer() {
        return null;
    }


    @Override
    public void crear() {
        if(!this.existeTabla()){
            tablaIntermediaEstudiantexCursoModelo.crearTablaIntermedia();
        }
        tablaIntermediaEstudiantexCursoModelo.crearregistroTablaIntermedia(this.getIdCurso(), this.getIdEstudiante());
    }

    @Override
    public boolean existeTabla() {
        return General.existeTabla("tablaintermediaestudiantesxcursos");
    }


    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
