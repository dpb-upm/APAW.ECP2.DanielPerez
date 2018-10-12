package api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaTest {

    private Sala sala;

    @BeforeEach
    void before() {
        this.sala = new Sala("1", "Sala prueba", 11);
    }

    @Test
    void testConstructor() {
        assertEquals("1", this.sala.getId());
        assertEquals("Sala prueba", this.sala.getNombre());
        assertEquals(11, this.sala.getCapacidad());

        this.sala.setNombre("Sala prueba 2");
        assertEquals("Sala prueba 2", this.sala.getNombre());

        this.sala.setCapacidad(22);
        assertEquals(22, this.sala.getCapacidad());
    }
}
