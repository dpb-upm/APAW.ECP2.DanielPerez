package api.entities;

public interface ArchivoComponent {

    void add(ArchivoComponent cc);

    boolean isComposite();

    void remove(ArchivoComponent cc);

    int total();

    String view();
}
