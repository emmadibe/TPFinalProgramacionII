package clasesGenerales;

import Excepciones.NoExisteIdException;

import java.lang.reflect.Field;
import java.util.List;

public class ArrayListParaTodos<T>
{
    List<T> arrayList;
    public ArrayListParaTodos()
    {
        this.arrayList = new java.util.ArrayList<T>();
    }
    public ArrayListParaTodos(int dimensionInicial)
    {
        this.arrayList = new java.util.ArrayList<T>(dimensionInicial);
    }

    public void agregar(T t)
    {
        this.arrayList.add(t);
    }

    public void imprimirTodos()
    {
        for(T t : this.arrayList){
            System.out.println(t);//Automáticamente, si no aclaro, se aplica el metodo toString, el cual lo sobreescribí.
        }
    }

    public boolean estaVacio()
    {
        return this.arrayList.isEmpty();
    }

    public boolean existeIdEnArrayList(int idBuscado) throws NoExisteIdException
    { //Este metodo va a buscar en el ArrayList generico si existe una instancia de la clase T que tenga en su atributo id el entero que le paso por parámetro. De encontrarlo, retorna true; sino, false.
        for (T t : this.arrayList) { //Este es un bucle for each.
            try {
                Field campoId = t.getClass().getDeclaredField("id"); //La clase Field en Java es una parte del paquete de java.lang.reflect. Me otorga métodos para acceder y manipular los campos de una clase.
                campoId.setAccessible(true); // Permite acceder a campos privados
                Object valorId = campoId.get(t); // Obtiene el valor del campo 'id'
                if (valorId instanceof Integer && valorId.equals(idBuscado)) {
                    return true; // Se encontró el ID buscado
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Manejo de excepciones si el campo no existe o no se puede acceder
                e.printStackTrace();
            }
        }
        throw new NoExisteIdException("No existe un examen con ese número de ID."); // No se encontró el ID buscado
    }

    public int traerPosicionDelElementoEnElArrayListPorId(int idBuscado) {
        for (int i = 0; i < this.arrayList.size(); i++) {
            T t = this.arrayList.get(i);
            try {
                Field campoId = t.getClass().getDeclaredField("id"); // Busca el campo 'id'
                campoId.setAccessible(true); // Permite acceder a campos privados
                Object valorId = campoId.get(t); // Obtiene el valor del campo 'id'
                if (valorId instanceof Integer && valorId.equals(idBuscado)) {
                    return i; // Retorna la posición del elemento
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Manejo de excepciones si el campo no existe o no se puede acceder
                e.printStackTrace();
            }
        }
        return -1; // Retorna -1 si no se encontró el ID buscado
    }

    public T traerElementoPorPosicion(int posicion)
    {
        return this.arrayList.get(posicion);
    }

    public int tamanio()
    {
        return this.arrayList.size();
    }

    public T retornarElementoPorPosicion(int posicion)
    {
        return this.arrayList.get(posicion);
    }
}
