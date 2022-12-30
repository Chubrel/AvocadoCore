package com.github.chubrel.avocado_core.value_generators;

public class FloatGeneratorWithStartValue implements FloatGenerator {
    
    private final FloatGenerator generator;
    private final float startValue;
    private boolean first = true;

    public FloatGeneratorWithStartValue(FloatGenerator generator, float startValue) {
        this.generator = generator;
        this.startValue = startValue;
    }

    @Override
    public float next() {
        if (first) {
            first = false;
            return startValue;
        }
        return generator.next();
    }
}
