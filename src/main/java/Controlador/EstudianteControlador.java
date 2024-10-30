package Controlador;

import Modelos.EstudiantesModelo;
import Modelos.General;
import clasesGenerales.ArrayListParaTodos;
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
    public ArrayListParaTodos<Estudiante> traer()
    {
        ArrayListParaTodos<Estudiante> estudianteArrayList = new ArrayListParaTodos<Estudiante>(100);
        EstudiantesModelo estudiantesModelo1 = new EstudiantesModelo();
        estudianteArrayList = estudiantesModelo1.traerTodos(this.getCursoID());
        return estudianteArrayList;
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
        int idEstudiante = estudiantesModelo.getIDULTIMOREGISTROBDD(); //Necesito el id del estudiante recién creado para la tabla intermedia
        TablaIntermediaEstudiantexCursoControlador tIEXC = new TablaIntermediaEstudiantexCursoControlador(this.getCursoID(), idEstudiante);
        tIEXC.crear(); //Creo la tabla intermedia entre cursos y estudiantes. Es una relación N : N.
    }

    @Override
    public void editar(Estudiante estudiante) {

    }

    @Override
    public void eliminar(Estudiante estudiante) {

    }

    public int getIDUltimoRegistro()
    {
        return 0;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
}
