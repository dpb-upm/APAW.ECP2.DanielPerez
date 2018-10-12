package api.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorySingletonTest {

    @Test
    void testConstructor() {
        FactorySingletonServidor factory = FactorySingletonServidor.getFactory();
        factory.getFactory().addArchivo(new Archivo.Builder().id("1").descripcion("Archivo de prueba").tamanio(10).build());
        factory.addArchivo(new Archivo.Builder().id("2").descripcion("Archivo de prueba 2").tamanio(10).build());
        assertEquals(2, factory.getServidor().getArchivos().size());

        factory.borrarArchivos();
        assertEquals(0, factory.getServidor().getArchivos().size());
    }
}
