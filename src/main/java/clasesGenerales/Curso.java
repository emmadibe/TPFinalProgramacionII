package clasesGenerales;

import interfaces.Entidades;

import java.util.Scanner;

public class Curso implements Entidades<Curso>
{
    private String nombre;
    private String escuela;
    private int cantidadAlumnos;
    private String materia;
    private int docenteID;

    public static Scanner ingresar = new Scanner(System.in);

    public Curso()
    {

    }
    public Curso(String nombre, int cantidadAlumnos, String materia, String escuela)
    {
        this.setNombre(nombre);
        this.setCantidadAlumnos(cantidadAlumnos);
        this.setMateria(materia);
        this.setEscuela(escuela);
    }
    @Override
    public Curso crearInstancia()
    {
        System.out.println("Nombre del curso: ");
        String nombre = ingresar.nextLine();
        System.out.println("Cantidad de alumnos: ");
        int cantAlumnos = ingresar.nextInt();
        System.out.println("Materia: ");
        String materia = ingresar.nextLine();
        System.out.println("Escuela: ");
        String escuela = ingresar.nextLine();

        return new Curso(nombre, cantidadAlumnos, materia, escuela);
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
    public void setEscuela(String escuela){
        this.escuela = escuela;
    }

    public String getEscuela() {
        return escuela;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
