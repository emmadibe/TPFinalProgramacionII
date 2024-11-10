package interfaces;

import Excepciones.NuloException;

public interface Entidades<T>
{
    public T crearInstancia();
    public void imprimirUnaInstancia() throws NuloException;
    public void actualizarSeteo(T t);
    public boolean esNullo();
}
