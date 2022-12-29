package com.github.chubrel.avocado_core.value_generators;

import java.util.Random;

public class FloatIntervalRandomGenerator implements FloatGenerator {
    
    private final Random random;
    private final float offset;
    private final float limit;

    public FloatIntervalRandomGenerator(float min, float max) {
        this(new Random(), min, max);
    }

    public FloatIntervalRandomGenerator(Random random, float min, float max) {
        this.random = random;
        offset = min;
        limit = max - min;
    }

    public float next() {
        return offset + limit * random.nextFloat();
    }
}
