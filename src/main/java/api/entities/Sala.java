package api.entities;

public class Sala {

    private String id;
    private String nombre;
    private int capacidad;

    public Sala(String nombre, int capacidad) {
        this.setNombre(nombre);
        this.setCapacidad(capacidad);
    }

    public Sala(String id, String nombre, int capacidad) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCapacidad(capacidad);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
