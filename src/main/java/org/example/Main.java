package org.example;

import java.util.Scanner;

public class Main {

    public static Scanner ingresar = new java.util.Scanner(System.in);

    public static void main(String[] args)
    {
        Main.opcionesMenuLogueo();
        int opcion;
        do{
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

            case 0:
                System.out.println("Chau!");
                break;

            default:
                System.out.println("Ingrese una opcion valida!");
                break;
        }
    }
}