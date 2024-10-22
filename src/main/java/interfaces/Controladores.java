package interfaces;

import clasesGenerales.Docente;

public interface Controladores<T>
{
    public  void crear();
    public boolean existeTabla();
    public T existe();
    public void eliminar(T t);
    public void editar(T t);
    public T traer();
}
