package org.deroesch.gofpatterns.chainofcommand;

import lombok.NonNull;

public abstract class GizmoChain {

    /**
     * No successor
     */
    public GizmoChain() {
        super();
    }

    /**
     * With successor
     */
    public GizmoChain(@NonNull GizmoChain successor) {
        super();
        this.successor = successor;
    }

    // Run the chain.
    final public void execute() {
        if (!handler() && hasSuccessor())
            successor.execute();
    }

    boolean hasSuccessor() {
        return null != successor;
    }

    // Can I handle this?
    public abstract boolean handler();

    // Who's next?
    @NonNull
    private GizmoChain successor;

}
