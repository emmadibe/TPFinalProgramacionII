package Controlador;

public class TablaIntermediaEstudiantexCursoControlador
{
    private int id;
    private int idCurso;
    private int idEstudiante;
    public TablaIntermediaEstudiantexCursoControlador(int idCurso, int idEstudiante)
    {
        this.setIdCurso(idCurso);
        this.setIdEstudiante(idEstudiante);
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
