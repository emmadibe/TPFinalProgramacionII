package Controlador;

import clasesGenerales.Estudiante;
import interfaces.Controladores;

public class EstudianteControlador implements Controladores<Estudiante>
{
    @Override
    public Estudiante existe() {
        return null;
    }

    @Override
    public Estudiante traer() {
        return null;
    }

    @Override
    public boolean existeTabla() {
        return false;
    }

    @Override
    public void crear()//Creo una instancia de la clase Estudiante y lo guardo en la BDD
    {

    }

    @Override
    public void editar(Estudiante estudiante) {

    }

    @Override
    public void eliminar(Estudiante estudiante) {

    }
}
