package org.deroesch.gofpatterns.singleton;

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
