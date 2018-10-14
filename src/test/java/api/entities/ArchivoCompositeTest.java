package api.entities;

import api.exceptions.IsALeafException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoCompositeTest {

    private ArchivoComponent root;
    private ArchivoComponent tree;
    private ArchivoComponent leaf;

    @BeforeEach
    void before() {
        DirectorioComposite directorioComposite = new DirectorioComposite("Directorio 1 raiz");
        this.leaf = new ArchivoLeaf("1 raiz", 1, "Archivo 1 leaf raiz");
        directorioComposite.add(this.leaf);

        this.root = directorioComposite;

        this.tree = new DirectorioComposite("Directorio 2");
        this.tree.add(new ArchivoLeaf("1 dir 2", 2, "Archivo 1 comp"));
        this.tree.add(new ArchivoLeaf("2 dir 2", 3, "Archivo 2 comp"));
        this.tree.add(new ArchivoLeaf("3 dir 2", 4, "Archivo 3 comp"));

        this.root.add(this.tree);
    }

    @Test
    void testComposite() {
        assertEquals(2, this.root.total());
        assertEquals(1, this.leaf.total());
        assertEquals(3, this.tree.total());
    }

    @Test
    void testIsComposite(){
        assertTrue(this.root.isComposite());
        assertTrue(this.tree.isComposite());
    }

    @Test
    void testIsNotComposite(){
        assertFalse(this.leaf.isComposite());
    }

    @Test
    void testView(){
        assertEquals("Leaf 1 raiz", this.leaf.view());
        assertEquals("Directorio 2", this.tree.view());
    }

    @Test
    void testRemove(){
        this.root.remove(this.leaf);
        assertEquals(1, this.root.total());
        assertEquals(1, this.leaf.total());
        assertEquals(3, this.tree.total());
    }

    @Test
    void testLeafAdd(){
        assertThrows(IsALeafException.class, () -> this.leaf.add(null));
    }

    @Test
    void testLeafRemove(){
        assertThrows(IsALeafException.class, () -> this.leaf.remove(null));
    }
}
