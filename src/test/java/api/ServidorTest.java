package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServidorTest {

    private Servidor servidor;

    @BeforeEach
    void before() {
        LocalDateTime localDateTime = LocalDateTime.of(1988, 05, 10, 0, 0);
        Propietario propietario = new Propietario("1", "Daniel", 30,localDateTime);
        this.servidor = new Servidor("1", TipoServidor.WEB, propietario);
    }

    @Test
    void testConstructor() {
        LocalDateTime localDateTime = LocalDateTime.of(1988, 05, 10, 0, 0);
        Propietario propietario = new Propietario("1", "Daniel", 30, localDateTime);
        assertEquals("1", this.servidor.getId());
        assertEquals(TipoServidor.WEB, this.servidor.getTipo());
        assertTrue(this.servidor.getPropietario().iguales(propietario));
        assertTrue(!this.servidor.isLleno());
        assertTrue(this.servidor.getArchivos().size() == 0);

        Propietario propietario2 = new Propietario("2", "Daniel", 35, localDateTime);
        this.servidor.setPropietario(propietario2);
        assertTrue(!this.servidor.getPropietario().iguales(propietario));

        this.servidor.setTipo(TipoServidor.CORREO);
        assertNotEquals(TipoServidor.WEB, this.servidor.getTipo());

        Archivo archivo = new Archivo("1", 10, "Doc prueba");
        this.servidor.setArchivo(archivo);
        assertTrue(this.servidor.getArchivos().size() > 0);

        Map<String, Archivo> emptyHasMap = new HashMap<>();
        this.servidor.setArchivos(emptyHasMap);
        assertTrue(this.servidor.getArchivos().size() == 0);
    }
}
