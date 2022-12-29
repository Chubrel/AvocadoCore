package com.github.chubrel.avocado_core.value_generators;

import java.util.Random;

public class IntIntervalRandomGenerator implements IntGenerator {

    private final Random random;
    private final int offset;
    private final int limit;

    public IntIntervalRandomGenerator(int min, int max) {
        this(new Random(), min, max);
    }

    public IntIntervalRandomGenerator(Random random, int min, int max) {
        this.random = random;
        offset = min;
        limit = max - min;
    }

    public int next() {
        return offset + random.nextInt(limit);
    }
}
