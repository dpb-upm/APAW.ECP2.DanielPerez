package api.dtos;

public class ArchivoDto {

    private String descripcion;
    private float tamanio;

    public ArchivoDto(String descripcion, float tamanio) {
        this.setTamanio(tamanio);
        this.setDescripcion(descripcion);
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
                ", tamaño='" + tamanio + '\'' +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
