package api.dtos;

import api.daos.DaoFactory;
import api.daos.memory.DaoFactoryMemory;
import api.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DtosTest {

    @BeforeEach
    void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    @Test
    void testDtos() {
        Archivo archivo = new Archivo.Builder().id("1").tamanio(100).descripcion("archivo 1").build();
        ArchivoDto archivoDto = new ArchivoDto(archivo);
        assertTrue(archivoDto.iguales(archivo));

        Propietario propietario = new Propietario("1", "Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00"));
        PropietarioDto propietarioDto = new PropietarioDto(propietario);
        assertTrue(propietarioDto.iguales(propietario));

        Sala sala = new Sala("1", "Sala prueba", 11);
        SalaDto salaDto = new SalaDto(sala);
        assertTrue(salaDto.iguales(sala));

        LocalDateTime localDateTime = LocalDateTime.of(1988, 05, 10, 0, 0);
        Servidor servidor = new Servidor("1", TipoServidor.WEB, propietario);
        ServidorDto servidorDto = new ServidorDto(servidor);
        assertTrue(servidorDto.iguales(servidor));
    }
}
