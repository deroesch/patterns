package org.deroesch.gofpatterns.singleton;

import lombok.NonNull;

/**
 * Singleton
 */
public class Gizmo {

    /**
     * Private constructor
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
        if (null == obj) {
            synchronized (Gizmo.class) {
                if (null == obj) {
                    obj = new Gizmo();
                }
            }
        }
        return obj;
    }

    // The singleton object
    private static Gizmo obj;
}
