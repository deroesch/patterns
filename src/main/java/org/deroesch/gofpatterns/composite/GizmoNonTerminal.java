package org.deroesch.gofpatterns.composite;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GizmoNonTerminal implements GizmoComposite {

    @Override
    public void sayHello() {
        log.info(String.format("Hello from Composite %s!", this));

        // Say hello from children, too.
        if (children().size() > 0) {
            log.info("My children are:");
            for (GizmoComposite obj : children())
                obj.sayHello();
        }
    }

    @Override
    public void add(@NonNull GizmoComposite obj) {
        if (obj == this)
            throw new IllegalArgumentException("Don't add yourself to yourself.");
        this.objects.add(obj);
    }

    @Override
    public void remove(@NonNull GizmoComposite obj) {
        this.objects.remove(obj);
    }

    @Override
    public boolean contains(@NonNull GizmoComposite obj) {
        return this.objects.contains(obj);
    }

    @Override
    @NonNull
    public Set<GizmoComposite> children() {
        return Collections.unmodifiableSet(objects);
    }

    private Set<GizmoComposite> objects = new HashSet<>();

    @Override
    public boolean isLeaf() {
        return false;
    }
}
