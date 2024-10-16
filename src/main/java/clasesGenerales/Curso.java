package clasesGenerales;

import interfaces.Entidades;

public class Curso implements Entidades<Curso>
{
    private String nombre;
    private int cantidadAlumnos;
    private String materia;
    private int docenteID;

    public Curso()
    {

    }
    public Curso(String nombre, int cantidadAlumnos, String materia, int docenteID)
    {
        this.setNombre(nombre);
        this.setCantidadAlumnos(cantidadAlumnos);
        this.setMateria(materia);
        this.setDocenteID(docenteID);
    }
    @Override
    public Curso crearInstancia()
    {
        return null;
    }

    @Override
    public void actualizarSeteo(Curso curso)
    {

    }

    @Override
    public void imprimirUnaInstancia()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getDocenteID() {
        return docenteID;
    }

    public void setDocenteID(int docenteID) {
        this.docenteID = docenteID;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
