package com.github.chubrel.avocado_core.value_generators;

import java.util.Random;

public class LongIntervalRandomGenerator implements LongGenerator {

    private final Random random;
    private final long offset;
    private final long limit;

    public LongIntervalRandomGenerator(long min, long max) {
        this(new Random(), min, max);
    }

    public LongIntervalRandomGenerator(Random random, long min, long max) {
        this.random = random;
        offset = min;
        limit = max - min;
    }

    public long next() {
        return offset + random.nextLong() % limit;
    }
}
