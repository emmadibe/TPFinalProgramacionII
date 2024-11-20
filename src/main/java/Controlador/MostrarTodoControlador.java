package Controlador;

import Modelos.MostrarTodoModelo;
import clasesGenerales.ArrayListParaTodos;
import clasesGenerales.Curso;
import clasesGenerales.MostrarTodo;

import javax.swing.*;
import java.util.Vector;

public class MostrarTodoControlador
{

    public  Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("EstudianteID");
        columnNames.add("Nombre");
        columnNames.add("ExamenID");
        columnNames.add("NumeroExamen");
        columnNames.add("NombreExamen");
        columnNames.add("Nota");
        return columnNames;
    }

    public Vector<Vector<Object>> getData(int cursoID)
    {
        MostrarTodoModelo mostrarTodoModelo = new MostrarTodoModelo();
        Vector<Vector<Object>> data = new Vector<>();
        data = MostrarTodoModelo.getData(cursoID);//Ya tengo todos los registros, con todos los exámenes del curso con todos los alumnos y sus notas.
        System.out.println("Número de registros obtenidos: " + data.size()); // Para depuración
        return data;
    }

    public void mostrarTabla(Curso curso)
    {
        try {
            Vector<Vector<Object>> data = this.getData(curso.getId());
            Vector<String> columnNames = this.getColumnNames();

            JTable tabla = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(tabla);

            JFrame frame = new JFrame("Registros del curso " + curso.getNombre() +" cuyo id es " + curso.getId() + ".");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(500, 300);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
