package Vistas;

import Controlador.CursoControlador;
import Controlador.DocenteControlador;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Docente;

import java.util.Objects;
import java.util.Scanner;

public class MenuDocente
{
    public static final Scanner ingresar = new Scanner(System.in);
    public static void menuInicialDocentes(Docente docente)
    {
        int opcion;
        do {
            MenuDocente.opcionesMenuInicialDocente(docente);
            opcion = ingresar.nextInt();
            if(opcion == 3){
                DocenteControlador docenteControlador = new DocenteControlador();
                docenteControlador.eliminar(docente);
                opcion = 0;
            }
            MenuDocente.menuPrincipalDocente(opcion, docente);
        }while (opcion != 0);
    }

    public static void menuPrincipalDocente(int opcion, Docente docente)
    {
        DocenteControlador docenteControlador = new DocenteControlador();
        CursoControlador cursoControlador = new CursoControlador(docente.getId());
        ArrayListParaTodos<Curso> cursoArrayList = new ArrayListParaTodos<Curso>(100);
        switch (opcion){
            case 0:
                System.out.println("Sesión cerrada.");
                break;
            case 1: //Ver datos.
                docente.imprimirUnaInstancia();
                break;
            case 2://Editar datos
                docenteControlador.editar(docente);
                break;
            case 4: //Crear un nuevo curso
                cursoControlador.crear();
                break;
            case 5: //Ver todos los cursos que posee el docente.
                cursoArrayList = cursoControlador.traer();
                cursoArrayList.imprimirTodos();
                break;
            case 6://Entrar a un curso.
                Curso curso = cursoControlador.existe();
                if(!Objects.isNull(curso)){
                    MenuCurso.menuInicialCurso(curso);
                }else{
                    System.out.println("No existe el curso.");
                }
                break;
            default:
                System.out.println("Opcion inválida.");
                break;
        }
    }

    public static void opcionesMenuInicialDocente(Docente docente)
    {
        System.out.println("Hola, " + docente.getNombre() + " " + docente.getApellido() + ".");
        System.out.println("¿Qué deseas hacer? ");
        System.out.println("0) Volver al menú principal. ");
        System.out.println("1)Ver sus datos. ");
        System.out.println("2)Actualizar datos.");
        System.out.println("3)Eliminar mi usuario.");
        System.out.println("4)Crear un nuevo curso.");
        System.out.println("5)Ver mis cursos");
        System.out.println("6)Entrar a un curso.");

    }
}
