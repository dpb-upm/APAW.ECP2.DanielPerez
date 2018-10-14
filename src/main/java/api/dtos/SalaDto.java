package api.dtos;

public class SalaDto {

    private String nombre;
    private int capacidad;

    public SalaDto(String nombre, int capacidad) {
        this.setNombre(nombre);
        this.setCapacidad(capacidad);
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

    @Override
    public String toString(){
        return "SalaDto{" +
            ", nombre='" + nombre + '\'' +
            "capacidad='" + capacidad + '\'' +
            '}';
    }
}
