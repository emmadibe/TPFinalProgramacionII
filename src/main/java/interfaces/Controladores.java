package interfaces;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;

public interface Controladores<T>
{
    public  void crear();
    public boolean existeTabla();
    public T existe();
    public void eliminar(T t);
    public void editar(T t);
    public ArrayListParaTodos traer();
}
