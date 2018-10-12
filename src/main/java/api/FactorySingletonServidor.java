package api;

public class FactorySingletonServidor extends Observable<Archivo> {

    private static FactorySingletonServidor factoryServidor;
    private Servidor servidor;

    public static FactorySingletonServidor getFactory(){
        if(factoryServidor == null){
            factoryServidor = new FactorySingletonServidor();
        }
        return factoryServidor;
    }

    public void borrarArchivos() {
        this.servidor.borrarArchivos();
    }

    public Servidor getServidor() {
        if(this.servidor == null){
            this.servidor = new Servidor();
        }
        return this.servidor;
    }

    public void addArchivo(Archivo archivo){
        if(this.servidor == null){
            this.servidor = new Servidor();
        }
        this.servidor.setArchivo(archivo);
        this.notifyObservers(archivo);
    }
}
