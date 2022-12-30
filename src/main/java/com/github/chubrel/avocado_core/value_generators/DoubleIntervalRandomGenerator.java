package com.github.chubrel.avocado_core.value_generators;

import java.util.Random;

public class DoubleIntervalRandomGenerator implements DoubleGenerator {

    private final Random random;
    private final double offset;
    private final double limit;

    public DoubleIntervalRandomGenerator(double min, double max) {
        this(new Random(), min, max);
    }

    public DoubleIntervalRandomGenerator(Random random, double min, double max) {
        this.random = random;
        offset = min;
        limit = max - min;
    }

    public double next() {
        return offset + limit * random.nextDouble();
    }
}
