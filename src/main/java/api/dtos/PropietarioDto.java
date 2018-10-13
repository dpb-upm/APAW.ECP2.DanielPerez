package api.dtos;

import java.time.LocalDateTime;

public class PropietarioDto {

    private String nombre;
    private int edad;
    private LocalDateTime nacimiento;

    public PropietarioDto(String nombre, int edad, LocalDateTime nacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacimiento = nacimiento;
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
}
