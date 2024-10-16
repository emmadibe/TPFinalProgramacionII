package Controlador;

import clasesGenerales.Curso;
import clasesGenerales.Docente;
import interfaces.Controladores;

public class CursoControlador implements Controladores<Curso>
{

    public void crear()
    {

    }

    @Override
    public Curso existe() {
        return null;
    }

    @Override
    public void editar(Curso curso) {

    }

    @Override
    public void eliminar(Curso curso) {

    }

    @Override
    public boolean existeTabla() {
        return false;
    }
}
