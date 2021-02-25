package org.deroesch.gofpatterns.singleton;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GizmoTest {

    @Test
    void testGet() {
        GizmoSingleton gizmoSingleton = GizmoSingleton.get();

        // Can never be null
        assertNotNull(gizmoSingleton);

        // Check for identical objects
        assertSame(gizmoSingleton, GizmoSingleton.get());
        assertSame(GizmoSingleton.get(), GizmoSingleton.get());
    }
}
