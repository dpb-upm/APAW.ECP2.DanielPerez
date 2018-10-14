package api.daos;

import api.daos.memory.DaoFactoryMemory;
import api.entities.*;
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

        DaoFactory.getFactory().getPropietarioDAO().save(new Propietario("1"));
        assertTrue(DaoFactory.getFactory().getPropietarioDAO().total() == 1);
        DaoFactory.getFactory().getPropietarioDAO().deleteById("1");
        assertTrue(DaoFactory.getFactory().getPropietarioDAO().total() == 0);

        DaoFactory.getFactory().getSalaDAO().save(new Sala("1", "sala 1", 50));
        assertTrue(DaoFactory.getFactory().getSalaDAO().total() == 1);
        DaoFactory.getFactory().getSalaDAO().deleteById("1");
        assertTrue(DaoFactory.getFactory().getSalaDAO().total() == 0);

        DaoFactory.getFactory().getServidorDAO().save(new Servidor());
        DaoFactory.getFactory().getServidorDAO().save(new Servidor());
        assertTrue(DaoFactory.getFactory().getServidorDAO().total() == 2);
        DaoFactory.getFactory().getServidorDAO().deleteById("1");
        assertTrue(DaoFactory.getFactory().getServidorDAO().total() == 1);
    }
}
