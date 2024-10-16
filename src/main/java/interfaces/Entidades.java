package interfaces;

public interface Entidades<T>
{
    public T crearInstancia();
    public void imprimirUnaInstancia();
    public void actualizarSeteo(T t);
}
