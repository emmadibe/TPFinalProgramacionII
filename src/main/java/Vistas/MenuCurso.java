package Vistas;

import Controlador.EstudianteControlador;
import Controlador.ExamenControlador;
import Excepciones.NuloException;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Estudiante;
import clasesGenerales.Examen;

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
        ArrayListParaTodos<Estudiante> estudianteArrayListParaTodos = new ArrayListParaTodos<Estudiante>(200);
        ExamenControlador examenControlador = new ExamenControlador(curso.getId());
        switch (opcion){
            case 1:
                break;
            case 2:
                estudianteControlador.crear();
                break;
            case 3: //Ver todos los alumnos del curso.
                estudianteArrayListParaTodos = estudianteControlador.traer();
                estudianteArrayListParaTodos.imprimirTodos();
                break;
            case 4: //Agregar un examen al curso
                examenControlador.crear();
                break;
            case 5: //Entrar a un examen.
                Examen examen = examenControlador.existe();
                System.out.println(examen);
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    public static void opcionesCurso(Curso curso)
    {
        System.out.println("Estas en el curso: ");
        try {
            curso.imprimirUnaInstancia();
        }catch (NuloException e){
            e.printStackTrace();
        }
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1)Ver alumnos y notas del curso");
        System.out.println("2)Agregar un alumno");
        System.out.println("3)Ver todos los alumnos");
        System.out.println("4)Crear un examen nuevo");
        System.out.println("5)Ir a un examen del curso");
    }
}
