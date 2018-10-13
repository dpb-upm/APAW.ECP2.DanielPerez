package api.daos.memory;

import api.daos.*;

public class DaoFactoryMemory extends DaoFactory {

    private ArchivoDao archivoDao;
    private ServidorDao servidorDao;
    private PropietarioDao propietarioDao;
    private SalaDao salaDao;


    @Override
    public ArchivoDao getArchivoDAO() {
        if (this.archivoDao == null) {
            this.archivoDao = new ArchivoDaoMemory();
        }
        return this.archivoDao;
    }

    @Override
    public ServidorDao getServidorDAO() {
        if (this.servidorDao == null) {
            this.servidorDao = new ServidorDaoMemory();
        }
        return this.servidorDao;
    }

    @Override
    public PropietarioDao getPropietarioDAO() {
        if (this.propietarioDao == null) {
            this.propietarioDao = new PropietarioDaoMemory();
        }
        return this.propietarioDao;
    }

    @Override
    public SalaDao getSalaDAO() {
        if (this.salaDao == null) {
            this.salaDao = new SalaDaoMemory();
        }
        return this.salaDao;
    }
}
