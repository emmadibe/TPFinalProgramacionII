package org.example;

import Controlador.DocenteControlador;
import Modelos.ConsultasGenerales;
import Modelos.DocenteModelo;
import Modelos.EstudiantesModelo;
import clasesGenerales.Docente;
import com.codeup.TPFinal.ConexionTPFinal;

import java.util.Scanner;

public class Main {

    public static Scanner ingresar = new java.util.Scanner(System.in);

    public static void main(String[] args)
    {
        ConexionTPFinal.getConnection();
        int opcion;
        do{
            Main.opcionesMenuLogueo();
            opcion = ingresar.nextInt();
            Main.menuLogueo(opcion);
        }while(opcion != 0);
    }

    public static void opcionesMenuLogueo()
    {
        System.out.println("¡Bienvenido!");
        System.out.println("1) Iniciar Sesion. ");
        System.out.println("2) Crear un usuario. ");
        System.out.println("0) Salir. ");
    }

    public static void menuLogueo(int opcion)
    {
        switch (opcion){
            case 1:

                break;

            case 2:
                DocenteControlador.crearDocente();
                break;

            case 0:
                System.out.println("Chau!");
                break;

            default:
                System.out.println("Ingrese una opcion valida!");
                break;
        }
    }
}