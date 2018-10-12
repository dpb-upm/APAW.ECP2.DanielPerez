package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StrategyTest {

    @Test
    void testStrategy() {
        Propietario propietario = new Propietario.Builder().id("1").nombre("dani").build();

        assertEquals("dani", propietario.getNombre());

        propietario.setStrategyA();
        assertNotEquals("dani", propietario.getNombre());
        assertEquals("daniA", propietario.getNombre());

        propietario.setStrategyB();
        assertNotEquals("dani", propietario.getNombre());
        assertNotEquals("daniA", propietario.getNombre());
        assertEquals("daniB", propietario.getNombre());

        propietario.setStrategyDefault();
        assertEquals("dani", propietario.getNombre());
        assertNotEquals("daniA", propietario.getNombre());
        assertNotEquals("daniB", propietario.getNombre());
    }
}
