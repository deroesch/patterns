package org.deroesch.gofpatterns.composite;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GizmoComposite implements Gizmo {

    @Override
    public void sayHello() {
        log.info(String.format("Hello from Composite %s!", this));

        // Say hello from children, too.
        if (children().size() > 0) {
            log.info("My children are:");
            for (Gizmo obj : children())
                obj.sayHello();
        }
    }

    @Override
    public void add(@NonNull Gizmo obj) {
        if (obj == this)
            throw new IllegalArgumentException("Don't add yourself to yourself.");
        this.objects.add(obj);
    }

    @Override
    public void remove(@NonNull Gizmo obj) {
        this.objects.remove(obj);
    }

    @Override
    public boolean contains(@NonNull Gizmo obj) {
        return this.objects.contains(obj);
    }

    @Override
    @NonNull
    public Set<Gizmo> children() {
        return Collections.unmodifiableSet(objects);
    }

    private Set<Gizmo> objects = new HashSet<>();

    @Override
    public boolean isLeaf() {
        return false;
    }
}
