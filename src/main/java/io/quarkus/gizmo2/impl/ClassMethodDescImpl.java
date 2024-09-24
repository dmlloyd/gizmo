package io.quarkus.gizmo2.impl;

import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;

import io.quarkus.gizmo2.ClassMethodDesc;

public final class ClassMethodDescImpl extends MethodDescImpl implements ClassMethodDesc {
    ClassMethodDescImpl(final ClassDesc owner, final String name, final MethodTypeDesc type) {
        super(owner, name, type);
    }

    public boolean equals(final MethodDescImpl obj) {
        return obj instanceof ClassMethodDescImpl other && super.equals(other);
    }
}