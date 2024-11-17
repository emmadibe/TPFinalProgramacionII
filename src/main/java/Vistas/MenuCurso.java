package Vistas;

import Controlador.EstudianteControlador;
import Controlador.ExamenControlador;
import Controlador.TablaIntermediaEstudiantesXExamenControlador;
import Controlador.TablaIntermediaEstudiantexCursoControlador;
import Excepciones.NuloException;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Estudiante;
import clasesGenerales.Examen;
import interfaces.Menus;

import java.util.Objects;
import java.util.Scanner;

public class MenuCurso implements Menus<Curso>
{
    public static final Scanner ingresar = new Scanner(System.in);
    public void menuInicial(Curso curso)
    {
        int opcion;
        do{
            this.opciones(curso);
            opcion = ingresar.nextInt();
            this.menuPrincipal(opcion, curso);
        }while(opcion != 0);
    }

    public void menuPrincipal(int opcion, Curso curso)
    {
        EstudianteControlador estudianteControlador = new EstudianteControlador(curso.getId());
        ArrayListParaTodos<Estudiante> estudianteArrayListParaTodos = new ArrayListParaTodos<Estudiante>(200);
        ExamenControlador examenControlador = new ExamenControlador(curso.getId());
        switch (opcion){
            case 1:
                break;
            case 2: //Agregar un alumno al curso
                int flag = 0;
                do {
                    estudianteControlador.crear();
                    System.out.println("Presionar cualquier numero, para agregar otro alumno; 0, para salir.");
                    flag = ingresar.nextInt();
                }while (flag != 0);
                break;
            case 3: //Ver todos los alumnos del curso.
                estudianteArrayListParaTodos = estudianteControlador.traer();
                estudianteArrayListParaTodos.imprimirTodos();
                break;
            case 4: //Agregar un examen al curso
                examenControlador.crear();
                int examenID = examenControlador.retornarUltimoid();
                TablaIntermediaEstudiantesXExamenControlador tablaIntermediaEstudiantesXExamenControlador = new TablaIntermediaEstudiantesXExamenControlador(examenID, curso.getId());
                tablaIntermediaEstudiantesXExamenControlador.crear(); //Creo todos los registros de la tabla intermedia entre examenes y alumnos.
                break;
            case 5: //Entrar a un examen.
                Examen examen = examenControlador.existe();
                if(!Objects.isNull(examen)){
                    MenuExamen menuExamen = new MenuExamen();
                    menuExamen.menuInicial(examen);
                }else{
                    System.out.println("No existe un examen con ese id.");
                }
                break;
            case 6: //Veo todos los exámenes que pertenecen a este curso.
                ExamenVistas.verTodosLosExamenesDelCurso(curso.getId());
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    public void opciones(Curso curso)
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
        System.out.println("6)Ver todos los exámenes del curso.");
        System.out.println("7)Ver todas las notas de todos los alumnos en todos los exámeens del curso.");
    }
}
