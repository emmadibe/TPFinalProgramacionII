package Controlador;

import Modelos.General;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.TablaIntermediaEstudiantesXExamen;
import interfaces.Controladores;

public class TablaIntermediaEstudiantesXExamenControlador implements Controladores<TablaIntermediaEstudiantesXExamen>
{
    @Override
    public TablaIntermediaEstudiantesXExamen existe() {
        return null;
    }

    @Override
    public boolean existeTabla() {
        return General.existeTabla("TablaIntermediaEstudiantesXExamen");
    }

    @Override
    public void crear() {

    }

    @Override
    public void editar(TablaIntermediaEstudiantesXExamen tablaIntermediaEstudiantesXExamen) {

    }

    @Override
    public ArrayListParaTodos traer() {
        return null;
    }

    @Override
    public void eliminar(TablaIntermediaEstudiantesXExamen tablaIntermediaEstudiantesXExamen) {

    }

}
