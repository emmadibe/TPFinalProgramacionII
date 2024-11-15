package org.example;

import Controlador.DocenteControlador;
import Controlador.ExamenControlador;
import Controlador.TablaIntermediaEstudiantesXExamenControlador;
import Controlador.TablaIntermediaEstudiantexCursoControlador;
import Modelos.*;
import Vistas.MenuDocente;
import clasesGenerales.*;
import com.codeup.TPFinal.ConexionTPFinal;
import java.util.Scanner;

public class Main
{

    public static Scanner ingresar = new java.util.Scanner(System.in);

    public static void main(String[] args)
    {
        ConexionTPFinal.getConnection();
        TablaIntermediaEstudiantesXExamenControlador tablaIntermediaEstudiantesXExamenControlador = new TablaIntermediaEstudiantesXExamenControlador(1, 1, 1);
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
        DocenteControlador docenteControlador = new DocenteControlador();
        switch (opcion){
            case 1:
                Docente docente = docenteControlador.existe();
                if(docente!= null){
                    MenuDocente menuDocente = new MenuDocente();
                    menuDocente.menuInicial(docente);
                }else{
                    System.out.println("Usuario y/o contrasenia incorrectos.");
                }
                break;

            case 2:
                docenteControlador.crear();
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