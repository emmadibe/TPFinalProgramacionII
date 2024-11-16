package Vistas;

import Controlador.TablaIntermediaEstudiantesXExamenControlador;
import Modelos.TablaIntermediaEstudiantesXExamenModelo;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Examen;
import clasesGenerales.TablaIntermediaEstudiantesXExamen;

import java.util.Scanner;

public class ExamenVistas
{
    public static Scanner scanner = new Scanner(System.in);

    public int buscarExamenVista()
    {
        System.out.println("Id del examen a ingresar: ");
        int idExamenABuscar = scanner.nextInt();
        return idExamenABuscar;
    }

    public static void subirNotaDeAlumno(Examen examen)
    {
        TablaIntermediaEstudiantesXExamenControlador TIC = new TablaIntermediaEstudiantesXExamenControlador(examen.getId(), examen.getCursoID());
        TablaIntermediaEstudiantesXExamenModelo TIM = new TablaIntermediaEstudiantesXExamenModelo();
        ArrayListParaTodos<TablaIntermediaEstudiantesXExamen> arrayTI = new ArrayListParaTodos<>(10);
        arrayTI = TIC.traer();
        arrayTI.imprimirTodos();
        int flag = 0;
        do{
            scanner.nextLine();
            System.out.println("Nombre y apellido del alumno: ");
            String nombreApellido = scanner.nextLine();
            if(TIC.buscarPorNombreYApellido(nombreApellido, arrayTI)){
                int estudianteID = TIC.retornarIdEstudiantePorNombreYApellido(nombreApellido, arrayTI);
                System.out.println("Nota: ");
                int nota = scanner.nextInt();
                TIM.actualizar(nota, estudianteID);
            }else{
                System.out.println("No existe un alumno con ese nombre y apellido");
            }
            System.out.println("Marque 0, para salir; cualquier número, para agregar otra nota a otro alumno.");
            flag = scanner.nextInt();
        }while(flag != 0);
    }
}
