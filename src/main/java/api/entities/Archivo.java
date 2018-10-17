package api.entities;

public class Archivo {

    private String id;
    private String descripcion;
    private float tamanio;

    public Archivo(){}

    public Archivo(String id){
        this.id = id;
    }

    public Archivo(float tamanio, String descripcion) {
        this.id = null;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
    }

    public Archivo(String id, float tamanio, String descripcion) {
        this.id = id;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public static class Builder {

        private Archivo archivo = new Archivo();

        public Builder id(String id) {
            archivo.setId(id);
            return this;
        }

        public Builder descripcion(String nombre) {
            archivo.setDescripcion(nombre);
            return this;
        }

        public Builder tamanio(float tamanio){
            archivo.setTamanio(tamanio);
            return this;
        }

        public Archivo build() {
            return archivo;
        }
    }
}
