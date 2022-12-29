package com.github.chubrel.avocado_core.value_generators;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GeneratorWithPrependedValues<T> implements ValueGenerator<T> {

    private final @NotNull T[] prependedValues;
    private int index = 0;
    private final @NotNull ValueGenerator<T> valueGenerator;

    @SafeVarargs
    public GeneratorWithPrependedValues(@NotNull ValueGenerator<T> valueGenerator, @NotNull T... prependedValues) {
        this.prependedValues = prependedValues;
        this.valueGenerator = valueGenerator;
    }

    @Override
    @Nullable
    public T next() {
        if (index < prependedValues.length)
            return prependedValues[index++];
        return valueGenerator.next();
    }
}
