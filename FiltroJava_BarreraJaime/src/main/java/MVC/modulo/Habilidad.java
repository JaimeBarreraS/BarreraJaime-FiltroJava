package MVC.modulo;

public class Habilidad {
    private int id;
    private int idNinja;
    private String nombre;
    private String descripcion;

    public Habilidad(int id, int idNinja, String nombre, String descripcion) {
        this.id = id;
        this.idNinja = idNinja;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(int idNinja) {
        this.idNinja = idNinja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
