package com.github.chubrel.avocado_core.value_generators;

public class IntGeneratorWithStartValue implements IntGenerator {
    
    private final IntGenerator generator;
    private final int startValue;
    private boolean first = true;

    public IntGeneratorWithStartValue(IntGenerator generator, int startValue) {
        this.generator = generator;
        this.startValue = startValue;
    }

    @Override
    public int next() {
        if (first) {
            first = false;
            return startValue;
        }
        return generator.next();
    }
}
