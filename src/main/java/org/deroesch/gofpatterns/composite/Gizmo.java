package org.deroesch.gofpatterns.composite;

import java.util.Set;

import lombok.NonNull;

public interface Gizmo {

    void sayHello();

    void add(@NonNull Gizmo obj);

    void remove(@NonNull Gizmo obj);

    boolean contains(@NonNull Gizmo obj);

    @NonNull
    Set<Gizmo> children();
}