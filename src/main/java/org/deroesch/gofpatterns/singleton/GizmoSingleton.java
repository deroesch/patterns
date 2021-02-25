package org.deroesch.gofpatterns.singleton;

import lombok.NonNull;

/**
 * Singleton
 */
public class GizmoSingleton {

    /**
     * Private constructor
     */
    private GizmoSingleton() {
    }

    /**
     * Get the singleton instance
     * 
     * @return the singleton instance
     */
    @NonNull
    public static GizmoSingleton get() {
        if (null == obj) {
            synchronized (GizmoSingleton.class) {
                if (null == obj) {
                    obj = new GizmoSingleton();
                }
            }
        }
        return obj;
    }

    // The singleton object
    private static GizmoSingleton obj;
}
