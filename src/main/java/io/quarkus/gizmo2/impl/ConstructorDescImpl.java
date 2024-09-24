package io.quarkus.gizmo2.impl;

import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.util.Objects;

import io.quarkus.gizmo2.ConstructorDesc;

public final class ConstructorDescImpl implements ConstructorDesc {
    private final ClassDesc owner;
    private final MethodTypeDesc type;
    private final int hashCode;

    public ConstructorDescImpl(final ClassDesc owner, final MethodTypeDesc type) {
        this.owner = owner;
        this.type = type;
        hashCode = Objects.hash(owner, "<init>", type);
    }

    public ClassDesc owner() {
        return owner;
    }

    public String name() {
        return "<init>";
    }

    public MethodTypeDesc type() {
        return type;
    }

    public boolean equals(final Object obj) {
        return obj instanceof ConstructorDescImpl other && equals(other);
    }

    public boolean equals(final ConstructorDescImpl other) {
        return this == other || other != null && hashCode == other.hashCode && owner.equals(other.owner) && type.equals(other.type);
    }

    public int hashCode() {
        return hashCode;
    }
}