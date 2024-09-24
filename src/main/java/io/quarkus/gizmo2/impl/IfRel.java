package io.quarkus.gizmo2.impl;

import java.lang.constant.ClassDesc;

final class IfRel extends If {
    final ExprImpl a, b;

    IfRel(final ClassDesc type, final Kind kind, final BlockCreatorImpl whenTrue, final BlockCreatorImpl whenFalse, final ExprImpl a, final ExprImpl b) {
        super(type, kind, whenTrue, whenFalse);
        this.a = a;
        this.b = b;
    }

    IfOp op(final Kind kind) {
        return switch (a.typeKind().asLoadable()) {
            case INT -> kind.if_icmp;
            case REFERENCE -> kind.if_acmp;
            default -> throw new IllegalStateException();
        };
    }
}