package com.github.chubrel.avocado_core.value_generators;

import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FloatRandomValueGenerator extends RandomValueGenerator<Float> {

    public FloatRandomValueGenerator(Float min, Float max) {
        super(min, max);
    }

    public FloatRandomValueGenerator(Random random, Float min, Float max) {
        super(random, min, max);
    }

    @Override
    public @Nullable Float next() {
        return min + max * random.nextFloat();
    }
}
