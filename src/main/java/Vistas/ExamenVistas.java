package Vistas;

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
}
