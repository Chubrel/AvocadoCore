package com.github.chubrel.avocado_core.value_generators;

public class FloatGeneratorWithInitialOffset implements FloatGenerator {
    
    private final FloatGenerator generator;
    private final float initialOffset;
    private boolean first = true;

    public FloatGeneratorWithInitialOffset(FloatGenerator generator, float initialOffset) {
        this.generator = generator;
        this.initialOffset = initialOffset;
    }

    @Override
    public float next() {
        if (first) {
            first = false;
            return initialOffset + generator.next();
        }
        return generator.next();
    }
}
