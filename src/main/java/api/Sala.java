package api;

public class Sala {

    private String id;
    private String nombre;
    private int capacidad;

    public Sala(String id, String nombre, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
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
