package org.deroesch.gofpatterns.composite;

import java.util.Set;

import lombok.NonNull;

public interface GizmoComposite {

    void sayHello();

    void add(@NonNull GizmoComposite obj);

    void remove(@NonNull GizmoComposite obj);

    boolean contains(@NonNull GizmoComposite obj);

    boolean isLeaf();

    @NonNull
    Set<GizmoComposite> children();

}