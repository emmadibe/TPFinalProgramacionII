package clasesGenerales;

import java.util.ArrayList;
import java.util.List;

public class CursoArrayList extends Curso implements interfaces.ArrayList<Curso>
{
    public List<Curso> cursoArrayList;

    public CursoArrayList(int dimensionInicial)
    {
        this.cursoArrayList = new ArrayList<>(dimensionInicial);
    }

    @Override
    public void add(Curso curso) {
        this.cursoArrayList.add(curso);
    }

    public void imprimirTodos()
    {
        if(this.cursoArrayList.isEmpty()){
            System.out.println("Usted aún no tiene cursos creados, pal");
        }else{
            for(Curso curso : this.cursoArrayList){
                curso.imprimirUnaInstancia();
            }
        }

    }

    @Override
    public boolean estaVacio() {
        return this.cursoArrayList.isEmpty();
    }

   public boolean existeIdEnArrayList(int id)
   {
       boolean existe = false;
        for(Curso curso : this.cursoArrayList){
            if(curso.getId() == id){
                existe = true;
                break;
            }
        }
        return existe;
   }

   public int traerPosicionDelElementoEnElArrayListPorId(int id)
   {
       int posicion = 0;
       for(int i = 0; i < this.cursoArrayList.size(); i++){
           if(this.cursoArrayList.get(i).getId() == id){
               posicion = i;
               break;
           }
       }
       return posicion;
   }

   public Curso traerElementoPorPosicion(int posicion)
   {
       String nombre = this.cursoArrayList.get(posicion).getNombre();
       String escuela = this.cursoArrayList.get(posicion).getEscuela();
       String materia = this.cursoArrayList.get(posicion).getMateria();
       int id = this.cursoArrayList.get(posicion).getId();
       int idDocente = this.cursoArrayList.get(posicion).getDocenteID();
       int cantAlumnos = this.cursoArrayList.get(posicion).getCantidadAlumnos();
       Curso curso = new Curso(nombre,cantAlumnos, materia, escuela, idDocente, id);
       return curso;
   }
}
