package api.dtos;

import api.entities.Propietario;

import java.time.LocalDateTime;

public class PropietarioDto {

    private String id;
    private String nombre;
    private int edad;
    private LocalDateTime nacimiento;

    public PropietarioDto(Propietario propietario) {
        this.id = propietario.getId();
        this.nombre = propietario.getNombre();
        this.edad = propietario.getEdad();
        this.nacimiento = propietario.getNacimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDateTime nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString(){
        return "PropietarioDto{" +
            "id='" + id + '\'' +
            ", nombre='" + nombre + '\'' +
            ", edad='" + edad + '\'' +
            "nacimiento='" + nacimiento.getDayOfMonth()+"/"+nacimiento.getMonth()+"/"+nacimiento.getYear() + '\'' +
            '}';
    }
}
