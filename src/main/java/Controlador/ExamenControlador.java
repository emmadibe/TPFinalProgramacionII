package Controlador;

import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.Examen;
import interfaces.Controladores;

public class ExamenControlador implements Controladores<Examen>
{

    @Override
    public void crear() {

    }

    @Override
    public ArrayListParaTodos<Curso> traer() {
        return null;
    }

    @Override
    public Examen existe() {
        return null;
    }

    @Override
    public void editar(Examen examen) {

    }

    @Override
    public void eliminar(Examen examen) {

    }

    @Override
    public boolean existeTabla() {
        return false;
    }

}
