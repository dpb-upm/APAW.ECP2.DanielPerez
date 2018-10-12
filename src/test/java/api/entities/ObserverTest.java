package api.entities;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {

    @Test
    void testObservable() {

        FactorySingletonServidor factory = FactorySingletonServidor.getFactory();
        Servidor servidor = new Servidor();

        factory.addObserver(servidor);
        factory.removeObserver(servidor);

        factory.addArchivo(new Archivo.Builder().id("1").descripcion("Archivo de prueba").tamanio(10).build());

        AtomicInteger total = new AtomicInteger();
        factory.getServidor().getArchivos().forEach((k, v) -> {
            if (v.getDescripcion().contains("NOTIFIED")){
                total.getAndIncrement();
            }
        });
        assertEquals(0, total.intValue());

        factory.addObserver(servidor);
        factory.addArchivo(new Archivo.Builder().id("2").descripcion("Archivo de prueba").tamanio(10).build());

        total.set(0);
        factory.getServidor().getArchivos().forEach((k, v) -> {
            if (v.getDescripcion().contains("NOTIFIED")){
                total.getAndIncrement();
            }
        });
        assertEquals(1, total.intValue());
    }
}
