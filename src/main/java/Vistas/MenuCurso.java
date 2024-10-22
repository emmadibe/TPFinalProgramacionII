package Vistas;

import clasesGenerales.Curso;

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
        }while(opcion != 0);
    }

    public static void menuPrincipalCurso(int opcion, Curso curso)
    {
        switch (opcion){
            case 1:
                break;
            case 2:
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
