package clasesGenerales;

import interfaces.Entidades;

import java.util.Scanner;

public class Curso implements Entidades<Curso>
{
    private int id;
    private String nombre;
    private String escuela;
    private int cantidadAlumnos;
    private String materia;
    private int docenteID;

    public static Scanner ingresar = new Scanner(System.in);

    public Curso()
    {

    }
    public Curso(String nombre, int cantidadAlumnos, String materia, String escuela, int docenteID)
    {
        this.setNombre(nombre);
        this.setCantidadAlumnos(cantidadAlumnos);
        this.setMateria(materia);
        this.setEscuela(escuela);
        this.setDocenteID(docenteID);
    }
    public Curso(String nombre, int cantidadAlumnos, String materia, String escuela, int docenteID, int id) //Constructor que uso para traerme los registros de cursos de mi BDD
    {
        this.setNombre(nombre);
        this.setCantidadAlumnos(cantidadAlumnos);
        this.setMateria(materia);
        this.setEscuela(escuela);
        this.setDocenteID(docenteID);
        this.setId(id);
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
        ingresar.nextLine();
        System.out.println("Materia: ");
        String materia = ingresar.nextLine();
        System.out.println("Escuela: ");
        String escuela = ingresar.nextLine();

        return new Curso(nombre, cantAlumnos, materia, escuela);
    }

    @Override
    public void actualizarSeteo(Curso curso)
    {

    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", escuela='" + escuela + '\'' +
                ", cantidadAlumnos=" + cantidadAlumnos +
                ", materia='" + materia + '\'' +
                ", docenteID=" + docenteID +
                '}';
    }

    @Override
    public void imprimirUnaInstancia()
    {
        System.out.println("------------------------------------");
        System.out.println("ID: " + this.getId());
        System.out.println("Escuela: " + this.getEscuela());
        System.out.println("Nombre del curso: " + this.getNombre());
        System.out.println("Materia: " + this.getMateria());
        System.out.println("Cantidad de alumnos: " + this.getCantidadAlumnos());
        System.out.println("ID del docente: " + this.getDocenteID());
        System.out.println("------------------------------------");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
