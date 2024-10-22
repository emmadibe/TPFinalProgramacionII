package Vistas;

import Controlador.EstudianteControlador;
import clasesGenerales.Curso;
import clasesGenerales.Estudiante;

import java.util.Scanner;

public class MenuCurso
{
    public static final Scanner ingresar = new Scanner(System.in);
    public static void menuInicialCurso(Curso curso)
    {
        int opcion;
        do{
            MenuCurso.opcionesCurso(curso);
            opcion = ingresar.nextInt();
            MenuCurso.menuPrincipalCurso(opcion, curso);
        }while(opcion != 0);
    }

    public static void menuPrincipalCurso(int opcion, Curso curso)
    {
        EstudianteControlador estudianteControlador = new EstudianteControlador(curso.getId());
        switch (opcion){
            case 1:
                break;
            case 2:
                estudianteControlador.crear();
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    public static void opcionesCurso(Curso curso)
    {
        System.out.println("Estas en el curso: ");
        curso.imprimirUnaInstancia();
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1)Ver alumnos y notas del curso");
        System.out.println("2)Agregar un alumno");
    }
}
