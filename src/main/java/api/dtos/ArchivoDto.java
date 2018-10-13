package api.dtos;

public class ArchivoDto {

    private String descripcion;
    private float tamanio;

    public ArchivoDto(float tamanio, String descripcion) {
        this.tamanio = tamanio;
        this.descripcion = descripcion;
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
}
