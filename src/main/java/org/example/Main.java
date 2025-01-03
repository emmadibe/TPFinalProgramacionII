package org.example;

import Controlador.*;
import Modelos.*;
import Vistas.ExamenVistas;
import Vistas.MenuDocente;
import Vistas.MenuExamen;
import clasesGenerales.*;
import com.codeup.TPFinal.ConexionTPFinal;
import java.util.Scanner;

public class Main
{

    public static Scanner ingresar = new java.util.Scanner(System.in);

    public static void main(String[] args)
    {
        ConexionTPFinal.getConnection();
        MostrarTodoControlador mostrarTodoControlador = new MostrarTodoControlador();
        Curso curso = new Curso("4toB", 7, "Geografia", "ees69", 1, 2 );
        mostrarTodoControlador.mostrarTabla(curso);
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