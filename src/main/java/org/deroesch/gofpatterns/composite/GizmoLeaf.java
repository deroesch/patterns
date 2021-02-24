package org.deroesch.gofpatterns.composite;

import java.util.Set;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GizmoLeaf implements Gizmo {

    @Override
    public void sayHello() {
        log.info(String.format("Hello from Leaf %s!", this));
    }

    @Override
    public void add(Gizmo obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Gizmo obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Gizmo obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Gizmo> children() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull
    NodeType getType() {
        return NodeType.LEAF;
    }
}
