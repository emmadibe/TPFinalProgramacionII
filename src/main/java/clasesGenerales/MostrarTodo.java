package clasesGenerales;

import Modelos.MostrarTodoModelo;

import java.util.Vector;
import javax.swing.*;

public class MostrarTodo
{
    int estudianteID;
    String estudianteNombre;
    int examenID;
    int numeroExamen;
    String nombreExamen;
    int nota;

    public MostrarTodo(int estudianteID, String estudianteNombre, int examenID, int numeroExamen, String nombreExamen, int nota)
    {
        this.setEstudianteID(estudianteID);
        this.setNota(nota);
        this.setNombreExamen(nombreExamen);
        this.setExamenID(examenID);
        this.setNumeroExamen(numeroExamen);
        this.setEstudianteNombre(estudianteNombre);
    }

    @Override
    public String toString() {
        return "MostrarTodo{" +
                "estudianteID=" + estudianteID +
                ", estudianteNombre='" + estudianteNombre + '\'' +
                ", examenID=" + examenID +
                ", numeroExamen=" + numeroExamen +
                ", nombreExamen='" + nombreExamen + '\'' +
                ", nota=" + nota +
                '}';
    }

//

//    public void imprimirTabla()
//    {
//        try {
////////            Vector<Vector<Object>> data = DataFetcher.getData();
////////            Vector<String> columnNames = DataFetcher.getColumnNames();
//////
//////            JTable table = new JTable(data, columnNames);
//////            JScrollPane scrollPane = new JScrollPane(table);
//////
//////            JFrame frame = new JFrame("Datos de la Base de Datos");
//////            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////            frame.add(scrollPane);
//////            frame.setSize(500, 300);
//////            frame.setVisible(true);
//////        } catch (Exception e) {
//////            e.printStackTrace();
//////        }
////    }
//    //}

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public int getNumeroExamen() {
        return numeroExamen;
    }

    public void setNumeroExamen(int numeroExamen) {
        this.numeroExamen = numeroExamen;
    }

    public int getExamenID() {
        return examenID;
    }

    public void setExamenID(int examenID) {
        this.examenID = examenID;
    }
}
