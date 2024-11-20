package clasesGenerales;

import interfaces.Entidades;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Estudiante extends Persona implements Entidades<Estudiante> {
    public static final Scanner ingresar = new Scanner(System.in);
    private int docenteId;
    private int cursoId;
    private String grado;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;

    public Estudiante() {

    }

    public Estudiante(String dni, String nombre, String apellido, int edad) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setApellido(apellido);
        this.setDni(dni);
    }

    public Estudiante(int id, String dni, String nombre, String apellido, int edad) {
        this.setId(id);
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setApellido(apellido);
        this.setDni(dni);
    }

    @Override
    public Estudiante crearInstancia() {
        ingresar.nextLine();
        System.out.println("DNI ");
        String dni = ingresar.nextLine();
        System.out.println("Nombre: ");
        String nombre = ingresar.nextLine();
        System.out.println("Apellido: ");
        String apellido = ingresar.nextLine();
        System.out.println("Edad");
        int edad = ingresar.nextInt();
        Estudiante estudiante = new Estudiante(dni, nombre, apellido, edad);
        return estudiante;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "ID='" + this.getId() + '\'' +
                "dni='" + this.getDni() + '\'' +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido='" + this.getApellido() + '\'' +
                ", edad=" + this.getApellido() +
                '}';
    }

    @Override
    public void actualizarSeteo(Estudiante estudiante){

    }

    public void actualizarAtributos(String atributo){
        try {
            Field campo = this.getClass().getDeclaredField(atributo);
            campo.setAccessible(true);

            System.out.println("Ingrese nuevo " + atributo + ": ");
            String nuevoValor = ingresar.nextLine().trim();

            if (campo.getType() == int.class) {
                int valorInt = Integer.parseInt(nuevoValor);
                if (atributo.equalsIgnoreCase("edad") && (valorInt < 0)) {
                    throw new IllegalArgumentException("La edad no puede ser menor a 0");
                }
                campo.set(this, valorInt);
            } else if (campo.getType() == String.class) {
                if (atributo.equals("dni") && !nuevoValor.matches("\\d{8}")) {
                    throw new IllegalArgumentException("El DNI debe tener 8 numeros");
                }
                if ((atributo.equalsIgnoreCase("nombre") || atributo.equalsIgnoreCase("apellido") && !nuevoValor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+"))){
                    throw new IllegalArgumentException("El nombre y apellido solo pueden contener letras");
                }
                if (nuevoValor.isEmpty()) {
                    throw new IllegalArgumentException("El valor no puede quedar vacio");
                }
                campo.set(this, nuevoValor);
            } else {
                System.out.println("No se puede modificar el atributo");
            }
            System.out.println("El atributo " + atributo + " fue modificado exitosamente");
        } catch (NoSuchFieldException e) {
            System.out.println("ERROR: El atributo " + atributo + " no existe.");
        } catch (NumberFormatException e) {
            System.out.println("ERROR: El valor ingresado no es valido.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("ERROR: No se pudo acceder al atributo " + atributo);
        }
    }

    public boolean esNullo()
    {
        return false;
    }
    @Override
    public void imprimirUnaInstancia()
    {

    }

    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
