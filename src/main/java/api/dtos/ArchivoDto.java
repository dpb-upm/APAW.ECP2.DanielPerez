package api.dtos;

import api.entities.Archivo;

public class ArchivoDto {

    private String id;
    private String descripcion;
    private float tamanio;

    public ArchivoDto(Archivo archivo) {
        this.id = archivo.getId();
        this.tamanio = archivo.getTamanio();
        this.descripcion = archivo.getDescripcion();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString(){
        return "ArchivoDto{" +
                "id='" + id + '\'' +
                ", tamaño='" + tamanio + '\'' +
                "id='" + descripcion + '\'' +
                '}';
    }
}
