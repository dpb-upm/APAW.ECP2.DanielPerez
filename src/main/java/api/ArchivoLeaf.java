package api;

public class ArchivoLeaf implements ArchivoComponent {

    private Archivo archivo;

    public ArchivoLeaf(String id, int tamanio, String descripcion) {
        this.archivo = new Archivo(id, tamanio, descripcion);
    }

    @Override
    public void add(ArchivoComponent cc) {
        // Es una hoja y no se implementa
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void remove(ArchivoComponent cc) {
        // Es una hoja y no se implementa
    }

    @Override
    public int total() {
        return 1;
    }

    @Override
    public String view() {
        return "Leaf " + this.archivo.getId();
    }
}
