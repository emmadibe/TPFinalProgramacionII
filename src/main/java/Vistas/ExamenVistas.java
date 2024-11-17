package Vistas;

import Controlador.ExamenControlador;
import Controlador.TablaIntermediaEstudiantesXExamenControlador;
import Modelos.TablaIntermediaEstudiantesXExamenModelo;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Examen;
import clasesGenerales.TablaIntermediaEstudiantesXExamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExamenVistas
{
    public  static  final Scanner scanner = new Scanner(System.in);

    public int buscarExamenVista()
    {
        System.out.println("Id del examen a ingresar: ");
        int idExamenABuscar = scanner.nextInt();
        return idExamenABuscar;
    }

    public static void subirNotaDeAlumno(Examen examen) {
        TablaIntermediaEstudiantesXExamenControlador TIC = new TablaIntermediaEstudiantesXExamenControlador(examen.getId(), examen.getCursoID());
        TablaIntermediaEstudiantesXExamenModelo TIM = new TablaIntermediaEstudiantesXExamenModelo();
        ArrayListParaTodos<TablaIntermediaEstudiantesXExamen> arrayTI = TIC.traer();
        arrayTI.imprimirTodos();

        int flag = -1;
        do {
            System.out.println("Nombre y apellido del alumno: ");
            scanner.nextLine(); // Clear the buffer
            String nombreApellido = scanner.nextLine().trim();

            System.out.println("Se ingresó el nombre: " + nombreApellido);

            if (TIC.buscarPorNombreYApellido(nombreApellido, arrayTI)) {
                int registroTIEEID = TIC.retornarIdEstudiantePorNombreYApellido(nombreApellido, arrayTI);
                System.out.println("Estudiante encontrado con ID: " + registroTIEEID);

                System.out.println("Nota: ");
                int nota = 0;
                boolean validNota = false;


                while (!validNota) {
                    try {
                        nota = scanner.nextInt();
                        validNota = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número válido para la nota.");
                        scanner.next();
                    }
                }

                TIM.actualizar(nota, registroTIEEID);
                System.out.println("Nota actualizada para el estudiante cuyo registro en la tabla intermedia tiene el ID: " + registroTIEEID);
            } else {
                System.out.println("No existe un alumno con ese nombre y apellido");
            }
            try {
                System.out.println("Marque 0, para salir; cualquier número, para agregar otra nota a otro alumno.");
                flag = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese un numero, solo numeros.");
            }
        } while (flag != 0);
    }

    public static void verTodosLosExamenesDelCurso(int cursoID)
    {
        ExamenControlador examenControlador = new ExamenControlador(cursoID);
        ArrayListParaTodos<Examen> arrayExamen = new ArrayListParaTodos<Examen>(100);
        arrayExamen = examenControlador.traer();
        arrayExamen.imprimirTodos();
    }
}
