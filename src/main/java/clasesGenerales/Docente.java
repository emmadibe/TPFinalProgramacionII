package clasesGenerales;

import java.util.Scanner;

public class Docente
{
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private String rama;
    public static final Scanner ingresar = new Scanner(System.in);

    public Docente(String nombre, String apellido, int edad, String email, String rama)
    {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setEmail(email);
        this.setRama(rama);
    }
    public static Docente crearDocente()
    {
        System.out.println("vamos a crear un nuevo docente.");
        System.out.println("Nombre: ");
        String nombre = ingresar.nextLine();
        System.out.println("Apellido: ");
        String apellido = ingresar.nextLine();
        System.out.println("Edad: ");
        int edad = ingresar.nextInt();
        System.out.println("Email: ");
        String email = ingresar.nextLine();
        System.out.println("Rama: ");
        String rama = ingresar.nextLine();

        Docente docente = new Docente(nombre, apellido, edad, email, rama);

        return docente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRama() {
        return rama;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }
}
