package Vistas;

import clasesGenerales.Examen;
import interfaces.Menus;

import java.util.Scanner;

public class MenuExamen implements Menus<Examen>
{
    public static final Scanner ingresar = new Scanner(System.in);

    @Override
    public void menuInicial(Examen examen)
    {
        int opcion = 0;
        do{
            this.opciones(examen);
            opcion = ingresar.nextInt();
        }while (opcion != 0);
    }

    @Override
    public void menuPrincipal(int opcion, Examen examen)
    {
        switch (opcion){
            case 1:
                break;
            default:
                System.out.println("Ingresar una opcion válida. ");
                break;
        }
    }

    @Override
    public void opciones(Examen examen)
    {
        System.out.println("Usted ha ingresado al examen: ");
        examen.imprimirUnaInstancia();
        System.out.println("Qué desea hacer?");
        System.out.println("1)Agregar notas a los alumnos.");
        System.out.println("2)Editar nota de un alumno.");
        System.out.println("3) Eliminar la nota de un alumno.");
        System.out.println("0) Volver al menú del curso.");
    }
}
