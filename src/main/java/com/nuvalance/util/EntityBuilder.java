package com.nuvalance.util;

import java.util.*;
import java.util.function.*;

public final class EntityBuilder<T> {

    private final Supplier<T> entitySupplier;
    private final Class<T> entityClass;
    private final List<Consumer<T>> entityModifiers;

    private EntityBuilder(final Supplier<T> entitySupplier,
                          final Class<T> entityClass) {
        this.entitySupplier = entitySupplier;
        this.entityClass = entityClass;
        this.entityModifiers = new ArrayList<>();
    }

    public T build() {
        final T entity = entitySupplier.get();
        entityModifiers.forEach(modifier -> modifier.accept(entity));
        return entity;
    }

    public <U> EntityBuilder<T> withModifier(final BiConsumer<T, U> modifier,
                                             final U value) {
        final Consumer<T> consumer = entity -> modifier.accept(entity, value);
        entityModifiers.add(consumer);
        return this;
    }

    public static <T> EntityBuilder<T> of(final Supplier<T> entitySupplier,
                                          final Class<T> entityClass) {
        return new EntityBuilder<>(entitySupplier, entityClass);
    }
}
