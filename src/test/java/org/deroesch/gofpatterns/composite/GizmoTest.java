package org.deroesch.gofpatterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "Composite")
public class GizmoTest {

    private GizmoComposite[] leaves;
    private GizmoComposite[] composites;

    @BeforeEach
    public void refreshTestObjects() {

        // New leaves (edge nodes)
        leaves = new GizmoComposite[10];
        for (int i = 0; i < leaves.length; i++)
            leaves[i] = new GizmoTerminal();

        // New composites (interior nodes)
        composites = new GizmoComposite[10];
        for (int i = 0; i < leaves.length; i++)
            composites[i] = new GizmoNonTerminal();
    }

    @Test
    @DisplayName(value = "Tree Composition")
    public void testNodeComposition() {
        final GizmoComposite root = composites[0];
        root.add(leaves[0]);
        root.add(leaves[1]);
        root.add(leaves[2]);
        root.add(leaves[3]);
        assertEquals(4, root.children().size());

        final GizmoComposite composite1 = composites[1];
        root.add(composite1);
        assertEquals(5, root.children().size());
        assertTrue(root.contains(composite1));

        composite1.add(leaves[4]);
        composite1.add(leaves[5]);
        composite1.add(leaves[6]);
        composite1.add(leaves[7]);
        assertEquals(4, composite1.children().size());
        assertEquals(5, root.children().size());

        final GizmoComposite composite2 = composites[2];
        root.add(composite2);
        assertTrue(root.contains(composite2));
        assertEquals(6, root.children().size());

        root.sayHello();
    }

    @Test
    @DisplayName(value = "Node Type")
    public void testNodeTypes() {
        assertTrue(leaves[0].isLeaf());
        assertFalse(composites[0].isLeaf());
    }

    @Test
    @DisplayName(value = "Unsupported Operations")
    public void testUnsupportedOperations() {
        final GizmoComposite root = composites[0];
        assertThrows(IllegalArgumentException.class, () -> root.add(root));

        final GizmoComposite leaf = leaves[0];
        assertThrows(UnsupportedOperationException.class, () -> leaf.add(root));
        assertThrows(UnsupportedOperationException.class, () -> leaf.remove(root));
        assertThrows(UnsupportedOperationException.class, () -> leaf.contains(root));
        assertThrows(UnsupportedOperationException.class, () -> leaf.children());
    }

    @Test
    @DisplayName(value = "Null Arugments")
    public void testNullArgs() {
        final GizmoComposite composite = composites[0];
        assertThrows(NullPointerException.class, () -> composite.add(null));
        assertThrows(NullPointerException.class, () -> composite.remove(null));
        assertThrows(NullPointerException.class, () -> composite.contains(null));
    }

    @Test
    @DisplayName(value = "Simple Add and Remove")
    public void testAddRemove() {
        final GizmoComposite root = composites[0];
        assertEquals(0, root.children().size());

        final GizmoComposite leaf = leaves[0];
        root.add(leaf);
        assertEquals(1, root.children().size());

        root.remove(leaf);
        assertEquals(0, root.children().size());
    }
}
