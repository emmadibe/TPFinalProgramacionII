package interfaces;

public interface ArrayList<T>
{
    public void add(T t);
    public void imprimirTodos();
    public boolean estaVacio();
    public boolean existeIdEnArrayList(int id);
    public int traerPosicionDelElementoEnElArrayListPorId(int id);
    public T traerElementoPorPosicion(int posicion);
}
