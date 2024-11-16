package clasesGenerales;

import Controlador.TablaIntermediaEstudiantesXExamenControlador;

import java.util.Objects;

public class TablaIntermediaEstudiantesXExamen
{
    private int id;
    private int alumnoID;
    private int examenID;
    private int nota;
    private String nombreYApellidoAlumno; //Es que me tengo que traer estos datos de los alumnos mediante una consulta INNER JOIN para que el docente sepa a qué alumno agregarle la nota.
    private String dniAlumno;

    public TablaIntermediaEstudiantesXExamen(int id, int examenID, int estudianteID, int nota, String nombreYApellidoAlumno, String dniAlumno)
    {
        this.setNota(nota);
        this.setId(id);
        this.setNombreYApellidoAlumno(nombreYApellidoAlumno);
        this.setDniAlumno(dniAlumno);
        this.setExamenID(examenID);
        this.setAlumnoID(estudianteID);
    }

    public TablaIntermediaEstudiantesXExamen(int id, int examenID, int estudianteID, int nota)
    {
        this.setId(id);
        this.setExamenID(examenID);
        this.setAlumnoID(estudianteID);
        this.setNota(nota);
    }

    @Override
    public String toString() {
        return "TablaIntermediaEstudiantesXExamen{" +
                "id=" + id +
                ", alumnoID=" + alumnoID +
                ", examenID=" + examenID +
                ", nota=" + nota +
                ", nombreYApellidoAlumno='" + nombreYApellidoAlumno + '\'' +
                ", dniAlumno='" + dniAlumno + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablaIntermediaEstudiantesXExamen that = (TablaIntermediaEstudiantesXExamen) o;
        return Objects.equals(nombreYApellidoAlumno, that.nombreYApellidoAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreYApellidoAlumno);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(int alumnoID) {
        this.alumnoID = alumnoID;
    }

    public int getExamenID() {
        return examenID;
    }

    public void setExamenID(int examenID) {
        this.examenID = examenID;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNombreYApellidoAlumno() {
        return nombreYApellidoAlumno;
    }

    public void setNombreYApellidoAlumno(String nombreYApellidoAlumno) {
        this.nombreYApellidoAlumno = nombreYApellidoAlumno;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }


}
