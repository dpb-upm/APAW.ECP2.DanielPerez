package api.entities;

import java.util.HashMap;
import java.util.Map;

public class Servidor implements Observer<Archivo> {

    private String id;
    private TipoServidor tipo;
    private boolean lleno;
    private Propietario propietario;
    private Map<String, Archivo> archivos;

    public Servidor(){
        this.lleno = false;
        this.createArchivo();
    }

    public Servidor(String id, TipoServidor tipo, Propietario propietario) {
        this.id = id;
        this.tipo = tipo;
        this.lleno = false;
        this.propietario = propietario;
        this.createArchivo();
    }

    public void borrarArchivos() {
        this.archivos.clear();
    }

    private void createArchivo(){
        this.archivos = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public TipoServidor getTipo() {
        return tipo;
    }

    public void setTipo(TipoServidor tipo) {
        this.tipo = tipo;
    }

    public boolean isLleno() {
        return lleno;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Map<String, Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(Map<String, Archivo> archivos) {
        this.archivos = archivos;
    }

    public void setArchivo(Archivo archivo) {
        this.archivos.put(archivo.getId(), archivo);
    }

    @Override
    public void update(Archivo object) {
        object.setDescripcion(object.getDescripcion()+" : NOTIFIED");
        this.archivos.put(object.getId(), object);
    }
}
