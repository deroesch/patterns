package org.deroesch.gofpatterns.singleton;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GizmoTest {

    @Test
    void testGet() {
        Gizmo gizmo = Gizmo.get();
        assertNotNull(gizmo);
        assertSame(gizmo, Gizmo.get());
        assertSame(Gizmo.get(), Gizmo.get());
    }
}
