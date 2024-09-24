package io.quarkus.gizmo2.impl.constant;

import java.util.Objects;
import java.util.Optional;

import io.github.dmlloyd.classfile.CodeBuilder;
import io.quarkus.gizmo2.impl.BlockCreatorImpl;

public final class EnumConstant extends ConstantImpl {
    private final Enum.EnumDesc<?> desc;
    private final int hashCode;

    public EnumConstant(final Enum.EnumDesc<?> desc) {
        super(desc.constantType());
        this.desc = desc;
        this.hashCode = Objects.hash(desc.constantName(), desc.constantType());
    }

    /**
     * {@return the name of the enum constant}
     */
    public String name() {
        return desc.constantName();
    }

    public Enum.EnumDesc<?> desc() {
        return desc;
    }

    public boolean equals(final ConstantImpl obj) {
        return obj instanceof EnumConstant other && equals(other);
    }

    public boolean equals(final EnumConstant other) {
        return this == other || other != null && name().equals(other.name()) && type().equals(other.type());
    }

    public int hashCode() {
        return hashCode;
    }

    public void writeCode(final CodeBuilder cb, final BlockCreatorImpl block) {
        // todo: this, or getstatic?
        cb.ldc(desc);
    }

    public Optional<Enum.EnumDesc<?>> describeConstable() {
        return Optional.of(desc());
    }
}