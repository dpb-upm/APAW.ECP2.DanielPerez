package api.daos;

public abstract class DaoFactory {

    private static DaoFactory factory = null;

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public abstract ArchivoDao getArchivoDAO();

    public abstract ServidorDao getServidorDAO();

    public abstract PropietarioDao getPropietarioDAO();

    public abstract SalaDao getSalaDAO();
}
