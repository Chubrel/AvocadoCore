package com.github.chubrel.avocado_core.value_generators;

public class LongGeneratorWithStartValue implements LongGenerator {
    
    private final LongGenerator generator;
    private final long startValue;
    private boolean first = true;

    public LongGeneratorWithStartValue(LongGenerator generator, long startValue) {
        this.generator = generator;
        this.startValue = startValue;
    }

    @Override
    public long next() {
        if (first) {
            first = false;
            return startValue;
        }
        return generator.next();
    }
}
