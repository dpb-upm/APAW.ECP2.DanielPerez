package api.entities;

import java.util.List;

public class DirectorioComposite implements ArchivoComponent {

    private String name;
    private List<ArchivoComponent> list;

    public DirectorioComposite(String name) {
        this.name = name;
        this.list = new java.util.ArrayList<>();
    }

    @Override
    public void add(ArchivoComponent ac) {
        list.add(ac);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void remove(ArchivoComponent ac) {
        list.remove(ac);
    }

    @Override
    public int total() {
        return this.list.size();
    }

    @Override
    public String view() {
        return this.name;
    }
}
