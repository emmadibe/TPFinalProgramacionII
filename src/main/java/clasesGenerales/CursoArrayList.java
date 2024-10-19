package clasesGenerales;

import java.util.ArrayList;
import java.util.List;

public class CursoArrayList extends Curso implements interfaces.ArrayList<Curso>
{
    public List<Curso> cursoArrayList;

    public CursoArrayList(int dimensionInicial)
    {
        this.cursoArrayList = new ArrayList<>(dimensionInicial);
    }

    @Override
    public void add(Curso curso) {
        this.cursoArrayList.add(curso);
    }
}
