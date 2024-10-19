package clasesGenerales;

public class Examen
{
    private String nombre;
    private int nota;
    private int estudianteID;
    private int cursoID;

    public Examen() {

    }

    public String getNombre() {
        return nombre;
    }


    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }
}
