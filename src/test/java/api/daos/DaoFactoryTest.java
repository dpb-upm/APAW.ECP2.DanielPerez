package api.daos;

import api.daos.memory.*;
import api.entities.Archivo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaoFactoryTest {

    @BeforeEach
    void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    @Test
    void testFactoryDao() {
        assertTrue(DaoFactory.getFactory().getArchivoDAO().total() == 0);
        DaoFactory.getFactory().getArchivoDAO().save(new Archivo.Builder().descripcion("archivo 1").build());
        assertTrue(DaoFactory.getFactory().getArchivoDAO().total() == 1);
        DaoFactory.getFactory().getArchivoDAO().deleteById("1");
        assertTrue(DaoFactory.getFactory().getArchivoDAO().total() == 0);
    }
}
