package org.deroesch.gofpatterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GizmoTest {

    private Gizmo[] leaves;
    private Gizmo[] composites;

    @BeforeEach
    public void initEach() {

        // New leaves
        leaves = new Gizmo[10];
        for (int i = 0; i < leaves.length; i++)
            leaves[i] = new GizmoLeaf();

        // New composites (interior nodes)
        composites = new Gizmo[10];
        for (int i = 0; i < leaves.length; i++)
            composites[i] = new GizmoComposite();
    }

    @Test
    public void testAggregation() {

        final Gizmo root = composites[0];
        root.add(leaves[0]);
        root.add(leaves[1]);
        root.add(leaves[2]);
        root.add(leaves[3]);
        assertEquals(4, root.children().size());

        final Gizmo composite1 = composites[1];
        root.add(composite1);
        assertEquals(5, root.children().size());
        assertTrue(root.contains(composite1));

        composite1.add(leaves[4]);
        composite1.add(leaves[5]);
        composite1.add(leaves[6]);
        composite1.add(leaves[7]);
        assertEquals(4, composite1.children().size());
        assertEquals(5, root.children().size());

        final Gizmo composite2 = composites[2];
        root.add(composite2);
        assertTrue(root.contains(composite2));
        assertEquals(6, root.children().size());

        root.sayHello();
    }

    @Test
    public void testTypes() {
        assertEquals(NodeType.LEAF, leaves[0].getType());
        assertEquals(NodeType.COMPOSITE, composites[0].getType());
    }

    @Test
    public void testProblems() {

        final Gizmo root = composites[0];
        assertThrows(IllegalArgumentException.class, () -> root.add(root));

        final Gizmo leaf = leaves[0];
        assertThrows(UnsupportedOperationException.class, () -> leaf.add(root));
        assertThrows(UnsupportedOperationException.class, () -> leaf.remove(root));
        assertThrows(UnsupportedOperationException.class, () -> leaf.contains(root));
        assertThrows(UnsupportedOperationException.class, () -> leaf.children());
    }

    @Test
    public void testNullArgs() {
        final Gizmo composite = composites[0];
        assertThrows(NullPointerException.class, () -> composite.add(null));
        assertThrows(NullPointerException.class, () -> composite.remove(null));
        assertThrows(NullPointerException.class, () -> composite.contains(null));
    }

    @Test
    public void testContainer() {
        final Gizmo root = composites[0];
        assertEquals(0, root.children().size());

        final Gizmo leaf = leaves[0];
        root.add(leaf);
        assertEquals(1, root.children().size());

        root.remove(leaf);
        assertEquals(0, root.children().size());
    }
}
