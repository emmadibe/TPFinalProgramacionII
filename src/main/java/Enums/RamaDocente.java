package Enums;

import java.util.Objects;

public enum RamaDocente
{
    HUMANIDADES("Humanidades", 1),
    LETRAS("Letras", 2),
    CIENCIASEXACTAS("Ciencias Exactas", 3),
    ARTISTICA("Artística", 4),
    EDUCACIONFISICA("Educacion Física", 5),
    OTRO("Otro", 6);

    String nombre;
    int orden;

    private RamaDocente(String nombre, int orden)
    {
        this.setOrden(orden);
        this.setNombre(nombre);
    }

    public static RamaDocente asignarRama(String rama)
    {
        RamaDocente ramaDocente;
        if(Objects.equals(rama, "humanidades")){
            ramaDocente = HUMANIDADES;
        }else if(Objects.equals(rama, "letras")){
            ramaDocente = LETRAS;
        }else if(Objects.equals(rama, "Ciencias Exactas")){
            ramaDocente = CIENCIASEXACTAS;
        }else if(Objects.equals(rama, "Artistica")){
            ramaDocente = ARTISTICA;
        }else if(Objects.equals(rama, "Educacion Fisica")){
            ramaDocente = EDUCACIONFISICA;
        }else{
            ramaDocente = OTRO;
        }
        return ramaDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
