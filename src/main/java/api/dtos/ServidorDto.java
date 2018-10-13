package api.dtos;

import api.entities.Archivo;
import api.entities.Propietario;
import api.entities.Servidor;
import api.entities.TipoServidor;

import java.util.HashMap;
import java.util.Map;

public class ServidorDto {

    private String id;
    private TipoServidor tipo;
    private boolean lleno;
    private Propietario propietario;
    private Map<String, Archivo> archivos;

    public ServidorDto(Servidor servidor) {
        this.id = servidor.getId();
        this.tipo = servidor.getTipo();
        this.lleno = servidor.isLleno();
        this.propietario = servidor.getPropietario();
        this.archivos = servidor.getArchivos();
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

    @Override
    public String toString(){
        return "SalaDto{" +
            "id='" + id + '\'' +
            ", tipo='" + tipo + '\'' +
            "lleno='" + lleno + '\'' +
            "propietario='" + propietario.getNombre() + '\'' +
            "archivos='" + archivos.size() + '\'' +
            '}';
    }
}
