package com.github.chubrel.avocado_core.value_generators;

import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class LongRandomValueGenerator extends RandomValueGenerator<Long> {

    public LongRandomValueGenerator(Long min, Long max) {
        super(min, max);
    }

    public LongRandomValueGenerator(Random random, Long min, Long max) {
        super(random, min, max);
    }

    @Override
    public @Nullable Long next() {
        return min + random.nextLong() % (max - min);
    }
}
