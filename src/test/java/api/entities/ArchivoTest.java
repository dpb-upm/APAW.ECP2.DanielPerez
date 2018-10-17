package api.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoTest {

    private Archivo archivo;

    @Test
    void testConstructor() {
        this.archivo = new Archivo("1", 100, "Documento de prueba");
        assertEquals("1", this.archivo.getId());
        assertEquals("Documento de prueba", this.archivo.getDescripcion());
        assertEquals(100, this.archivo.getTamanio());

        this.archivo.setDescripcion("otra desc");
        assertEquals("otra desc", this.archivo.getDescripcion());

        this.archivo.setTamanio(150);
        assertEquals(150, this.archivo.getTamanio());
    }

    @Test
    void testConstructorId() {
        this.archivo = new Archivo("1");
        assertEquals("1", this.archivo.getId());
        assertNull(this.archivo.getDescripcion());
        assertTrue(this.archivo.getTamanio() == 0);
    }
}
