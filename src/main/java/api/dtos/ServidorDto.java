package api.dtos;

import api.entities.Archivo;
import api.entities.Propietario;
import api.entities.TipoServidor;

import java.util.HashMap;
import java.util.Map;

public class ServidorDto {

    private TipoServidor tipo;
    private boolean lleno;
    private Propietario propietario;
    private Map<String, Archivo> archivos;

    public ServidorDto(TipoServidor tipo, Propietario propietario) {
        this.tipo = tipo;
        this.lleno = false;
        this.propietario = propietario;
        this.archivos = new HashMap<>();
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
}
