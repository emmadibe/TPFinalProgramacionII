package clasesGenerales;

import Enums.RamaDocente;
import interfaces.Entidades;

import java.util.Scanner;

public class Docente extends Persona implements Entidades<Docente>
{
    private String email;
    private RamaDocente ramaDocente;
    private String password;
    public static final Scanner ingresar = new Scanner(System.in);

    public Docente(){//Constructor vacío.

    }
    public Docente(String email, String password)
    {
        this.setEmail(email);
        this.setPassword(password);
    }
    public Docente(String nombre, String apellido, int edad, String email, String ramaDocente, String password)
    {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setEmail(email);
        this.setRamaDocente(RamaDocente.asignarRama(ramaDocente));
        this.setPassword(password);
    }
    public Docente(int id, String nombre, String apellido, int edad, String email, String rama, String password)
    {
        this.setId(id);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setEmail(email);
        this.setRamaDocente(RamaDocente.asignarRama(rama));
        this.setPassword(password);
    }
    public Docente crearInstancia()
    {
        System.out.println("Nombre: ");
        String nombre = ingresar.nextLine();
        System.out.println("Apellido: ");
        String apellido = ingresar.nextLine();
        System.out.println("Edad: ");
        int edad = ingresar.nextInt();
        ingresar.nextLine();
        System.out.println("Email: ");
        String email = ingresar.nextLine();
        System.out.println("Rama: ");
        String rama = ingresar.nextLine();
        System.out.println("Password: ");
        String password = ingresar.nextLine();

        Docente docente = new Docente(nombre, apellido, edad, email, rama, password);

        return docente;
    }

    public void actualizarSeteo(Docente docenteNuevosDatos)
    {
        this.setNombre(docenteNuevosDatos.getNombre());
        this.setApellido(docenteNuevosDatos.getApellido());
        this.setEdad(docenteNuevosDatos.getEdad());
        this.setEmail(docenteNuevosDatos.getEmail());
        this.setPassword(docenteNuevosDatos.getPassword());
        this.setRamaDocente(docenteNuevosDatos.getRamaDocente());
    }

    public void imprimirUnaInstancia()
    {
        System.out.println("-----------------------------------");
        System.out.println("ID: " + this.getId());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("Rama: " + this.getRamaDocente().getNombre());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Password: " + this.getPassword());
        System.out.println("-----------------------------------");
    }

    public void actualizarAtributosDocente(Docente docenteNuevo)
    {
        this.setNombre(docenteNuevo.getNombre());
        this.setApellido(docenteNuevo.getApellido());
        this.setEdad(docenteNuevo.getEdad());
        this.setRamaDocente(docenteNuevo.getRamaDocente());
        this.setPassword(docenteNuevo.getPassword());
    }

    public String getPassword(){
        return password;
    }

    public RamaDocente getRamaDocente(){
        return ramaDocente;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRamaDocente(RamaDocente ramaDocente){
        this.ramaDocente = ramaDocente;
    }

    public static class TablaIntermediaEstudiantesXCursos
    {
        private int cursoID;
        private int estudianteID;

        public int getCursoID() {
            return cursoID;
        }

        public void setCursoID(int cursoID) {
            this.cursoID = cursoID;
        }

        public int getEstudianteID() {
            return estudianteID;
        }

        public void setEstudianteID(int estudianteID) {
            this.estudianteID = estudianteID;
        }
    }
}
