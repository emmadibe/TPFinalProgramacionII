package Vistas;

import clasesGenerales.Curso;

import java.util.Scanner;

public class CursoVistas
{
    public static final Scanner ingresar = new Scanner(System.in);
    public static int buscarCursoVista()
    {
        System.out.println("Ingrese el id del curso a buscar");
        return  ingresar.nextInt();
    }
}
