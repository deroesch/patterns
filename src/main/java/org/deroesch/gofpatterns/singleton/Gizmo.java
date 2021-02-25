package org.deroesch.gofpatterns.singleton;

import lombok.NonNull;

/**
 * Singleton
 */
public class Gizmo {

    /**
     * Private ctor
     */
    private Gizmo() {
    }

    /**
     * Get the singleton instance
     * 
     * @return the singleton instance
     */
    @NonNull
    public static Gizmo get() {
        if (null == gizmo) {
            synchronized (Gizmo.class) {
                if (null == gizmo) {
                    gizmo = new Gizmo();
                }
            }
        }
        return gizmo;
    }

    // The singleton object
    private static Gizmo gizmo;
}
