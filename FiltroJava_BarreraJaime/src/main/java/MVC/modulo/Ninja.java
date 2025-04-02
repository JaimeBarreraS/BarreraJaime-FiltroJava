package MVC.modulo;

import java.util.ArrayList;
import java.util.List;

public class Ninja {
    private int id;
    private String nombre;
    private String rango;
    private String aldea;
    private List<String> habilidades;

    public Ninja(int id, String nombre, String rango, String aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad) {
        habilidades.add(habilidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public List<String> getHabilidades() {return habilidades;}
}
