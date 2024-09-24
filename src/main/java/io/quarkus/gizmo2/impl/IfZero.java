package io.quarkus.gizmo2.impl;

import java.lang.constant.ClassDesc;
import java.util.ListIterator;

final class IfZero extends If {
    final ExprImpl a;

    IfZero(final ClassDesc type, final Kind kind, final BlockCreatorImpl whenTrue, final BlockCreatorImpl whenFalse, final ExprImpl a) {
        super(type, kind, whenTrue, whenFalse);
        this.a = a;
    }

    protected void processDependencies(final BlockCreatorImpl block, final ListIterator<Item> iter, final boolean verifyOnly) {
        a.process(block, iter, verifyOnly);
    }

    IfOp op(final Kind kind) {
        return switch (a.typeKind().asLoadable()) {
            case INT -> kind.if_;
            case REFERENCE -> kind.if_acmpnull;
            default -> throw new IllegalStateException();
        };
    }
}