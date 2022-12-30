package com.github.chubrel.avocado_core.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class ObjectComparatorPlaceholder<T> implements ObjectComparator<T> {

    @Override
    @Contract("_ -> true")
    public boolean like(@Nullable T value) {
        return true;
    }
}
