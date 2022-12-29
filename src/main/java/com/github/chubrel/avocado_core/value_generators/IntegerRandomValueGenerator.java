package com.github.chubrel.avocado_core.value_generators;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class IntegerRandomValueGenerator extends RandomValueGenerator<Integer> {

    public IntegerRandomValueGenerator(Integer min, Integer max) {
        super(min, max);
    }

    public IntegerRandomValueGenerator(Random random, Integer min, Integer max) {
        super(random, min, max);
    }

    @Override
    public @NotNull Integer next() {
        return min + random.nextInt(max - min);
    }
}
