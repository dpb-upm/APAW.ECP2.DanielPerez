package api.dtos;

import api.entities.Sala;

public class SalaDto {

    private String id;
    private String nombre;
    private int capacidad;

    public SalaDto(Sala sala) {
        this.id = sala.getId();
        this.nombre = sala.getNombre();
        this.capacidad = sala.getCapacidad();
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

    public boolean iguales(Sala sala) {
        return this.id.equals(sala.getId()) && this.nombre.equals(sala.getNombre()) && this.capacidad == sala.getCapacidad();
    }

    @Override
    public String toString(){
        return "SalaDto{" +
            "id='" + id + '\'' +
            ", nombre='" + nombre + '\'' +
            "capacidad='" + capacidad + '\'' +
            '}';
    }
}
