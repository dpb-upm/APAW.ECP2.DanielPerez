package api.dtos;

import java.time.LocalDateTime;

public class PropietarioDto {

    private String nombre;
    private int edad;
    private LocalDateTime nacimiento;

    public PropietarioDto(String nombre, int edad, LocalDateTime fecha) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setNacimiento(fecha);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNacimiento(LocalDateTime nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getNacimiento() {
        return nacimiento;
    }

    @Override
    public String toString(){
        return "PropietarioDto{" +
            ", nombre='" + nombre + '\'' +
            ", edad='" + edad + '\'' +
            "nacimiento='" + nacimiento.getDayOfMonth()+"/"+nacimiento.getMonth()+"/"+nacimiento.getYear() + '\'' +
            '}';
    }
}
