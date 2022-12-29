package com.github.chubrel.avocado_core.value_generators;

import java.util.Random;

public abstract class RandomValueGenerator<T> implements ValueGenerator<T> {

    protected final Random random;
    protected final T min;
    protected final T max;

    public RandomValueGenerator(T min, T max) {
        this(new Random(), min, max);
    }

    public RandomValueGenerator(Random random, T min, T max) {
        this.random = random;
        this.min = min;
        this.max = max;
    }
}
