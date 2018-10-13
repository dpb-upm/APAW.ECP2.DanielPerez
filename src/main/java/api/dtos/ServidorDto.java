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

    public ServidorDto(TipoServidor tipo, boolean lleno) {
        this.setTipo(tipo);
        this.setLleno(lleno);
        this.setPropietario(null);
        this.setArchivos(new HashMap<>());
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

    public void setLleno(boolean lleno) {
        this.lleno = lleno;
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
            ", tipo='" + tipo + '\'' +
            "lleno='" + lleno + '\'' +
            "propietario='" + propietario.getNombre() + '\'' +
            "archivos='" + archivos.size() + '\'' +
            '}';
    }
}
