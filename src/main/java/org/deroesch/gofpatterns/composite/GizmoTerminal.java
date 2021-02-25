package org.deroesch.gofpatterns.composite;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GizmoTerminal implements GizmoComposite {

    @Override
    public void sayHello() {
        log.info(String.format("Hello from Leaf %s!", this));
    }

    @Override
    public void add(GizmoComposite obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(GizmoComposite obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(GizmoComposite obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<GizmoComposite> children() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
