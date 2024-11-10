package clasesGenerales;

import interfaces.Entidades;

import java.util.Scanner;

public class Examen implements Entidades<Examen>
{
    private int id;
    private String nombre;
    private int cursoID;
    private int numeroDeExamen;

    public static final Scanner ingresar = new Scanner(System.in);
    public Examen(){}

    public Examen(String nombre, int numeroDeExamen, int cursoID)
    {
        this.setNombre(nombre);
        this.setNumeroDeExamen(numeroDeExamen);
        this.setCursoID(cursoID);
    }
    public Examen(String nombre, int numeroDeExamen)
    {
        this.setNombre(nombre);
        this.setNumeroDeExamen(numeroDeExamen);
    }
    public Examen(int id, int cursoID, String nombre, int numeroExamen)
    {
        this.setId(id);
        this.setCursoID(cursoID);
        this.setNombre(nombre);
        this.setNumeroDeExamen(numeroExamen);
    }

    @Override
    public Examen crearInstancia()
    {
        ingresar.nextLine();
        System.out.println("Nombre del examen: ");
        String nombre = ingresar.nextLine();
        System.out.println("Numero del examen: ");
        int numeroExamen = ingresar.nextInt();
        return new Examen(nombre, numeroExamen);
    }

    @Override
    public void imprimirUnaInstancia() {

    }

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cursoID=" + cursoID +
                ", numeroDeExamen=" + numeroDeExamen +
                '}';
    }
    public boolean esNullo()
    {
        return false;
    }
    @Override
    public void actualizarSeteo(Examen examen) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public int getNumeroDeExamen() {
        return numeroDeExamen;
    }

    public void setNumeroDeExamen(int numeroDeExamen) {
        this.numeroDeExamen = numeroDeExamen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
