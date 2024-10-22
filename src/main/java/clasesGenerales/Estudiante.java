package clasesGenerales;

import interfaces.Entidades;

import java.util.Scanner;

public class Estudiante extends Persona implements Entidades<Estudiante>
{
    public static final Scanner ingresar = new Scanner(System.in);
    private int docenteId;
    private int cursoId;
    private String grado;
    public Estudiante()
    {

    }
    public Estudiante(String dni, String nombre, String apellido, int edad)
    {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setApellido(apellido);
        this.setDni(dni);
    }

    @Override
    public Estudiante crearInstancia() {
        ingresar.nextLine();
        System.out.println("DNI ");
        String dni = ingresar.nextLine();
        System.out.println("Nombre: ");
        String nombre = ingresar.nextLine();
        System.out.println("Apellido: ");
        String apellido = ingresar.nextLine();
        System.out.println("Edad");
        int edad = ingresar.nextInt();
        Estudiante estudiante = new Estudiante(dni, nombre, apellido, edad);
        return estudiante;
    }

    @Override
    public void actualizarSeteo(Estudiante estudiante) {

    }

    @Override
    public void imprimirUnaInstancia() {

    }

    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
