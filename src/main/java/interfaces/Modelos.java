package interfaces;

public interface Modelos<T>
{
    public void eliminarBDD(T t);
    public void actualizarBDD(T t);
    public void crearTablaBDD();
    public void agregarBDD(T t);
    public boolean existeBDD(T t);
}
