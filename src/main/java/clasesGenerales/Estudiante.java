package clasesGenerales;

import interfaces.Entidades;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Estudiante extends Persona implements Entidades<Estudiante>
{
    public static final Scanner ingresar = new Scanner(System.in);
    private int docenteId;
    private int cursoId;
    private String grado;
    private ArrayList <Examen> examenes;

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
        System.out.println("-----------------------------------");
        System.out.println("ID: " + this.getId());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Curso: " + this.curso.getNombre());
        System.out.println("Promedio: " + this.calcularPromedio());
        System.out.println("-----------------------------------");

    }
    public void actualizarAtributosPorTeclado() {
        System.out.println("Actualizar Atributos del Estudiante:");

        System.out.print("Nuevo Nombre:");
        String nuevoNombre = ingresar.nextLine();
        this.setNombre(nuevoNombre);

        System.out.print("Nuevo Apellido:");
        String nuevoApellido = ingresar.nextLine();
        this.setApellido(nuevoApellido);

        System.out.print("Nueva Edad: ");
        int nuevaEdad = ingresar.nextInt();
        ingresar.nextLine();
        this.setEdad(nuevaEdad);

        System.out.println("Atributos actualizados correctamente.");
    }

    public double calcularPromedio() {
        double promedio = 0.0;
        if (examenes.isEmpty()) {
            promedio = 0.0;
        } else {
            double suma = 0;
            for (Examen examen : examenes) {
                suma += examen.getNota();
            }
            promedio =  suma / examenes.size();
        }
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
