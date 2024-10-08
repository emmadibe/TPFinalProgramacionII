package Vistas;

import clasesGenerales.Docente;

import java.util.Scanner;

public class DocenteVistas
{
    public static final Scanner ingresar = new Scanner(System.in);
    public static Docente buscarDocenteVista()
    {
        System.out.println("Ingrese su email: ");
        String email = ingresar.nextLine();
        System.out.println("Ingrese su password");
        String password = ingresar.nextLine();
        Docente docente = new Docente(email, password);
        return docente;
    }

}
