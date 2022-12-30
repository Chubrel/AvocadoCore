package com.github.chubrel.avocado_core.value_generators;

import org.jetbrains.annotations.Nullable;

public interface ValueGenerator<T> {

    @Nullable T next();
}
