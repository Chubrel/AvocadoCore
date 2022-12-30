package com.github.chubrel.avocado_core.utils;

import org.jetbrains.annotations.Nullable;

public interface ObjectComparator<T> {

    boolean like(@Nullable T value);
}
