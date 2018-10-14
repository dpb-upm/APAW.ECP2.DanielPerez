package api.dtos;

import api.daos.DaoFactory;
import api.daos.memory.DaoFactoryMemory;
import api.entities.DateUtil;
import api.entities.TipoServidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DtosTest {

    @BeforeEach
    void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    @Test
    void testArchivoDto() {
        ArchivoDto archivoDto = new ArchivoDto("descripcion archivo", 100);
        assertTrue(archivoDto.getDescripcion().equals("descripcion archivo"));
        assertTrue(archivoDto.getTamanio() == 100);
    }

    @Test
    void testPropietarioDto() {
        PropietarioDto propietarioDto = new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00"));
        assertTrue(propietarioDto.getNombre().equals("Daniel"));
        assertTrue(propietarioDto.getEdad() == 30);
        assertTrue(propietarioDto.getNacimiento().isEqual(DateUtil.getFormatedDate("1988-05-10 00:00")));
    }

    @Test
    void testSalaDto() {
        SalaDto salaDto = new SalaDto("Sala prueba", 1);
        assertTrue(salaDto.getNombre().equals("Sala prueba"));
        assertTrue(salaDto.getCapacidad() == 1);
        assertFalse(salaDto.toString().isEmpty());
    }

    @Test
    void testServidorDto() {
        ServidorDto servidorDto = new ServidorDto(TipoServidor.WEB);
        assertTrue(servidorDto.getTipo().equals(TipoServidor.WEB));
        assertFalse(servidorDto.isLleno());
        assertTrue(servidorDto.getArchivos().isEmpty());
    }
}
