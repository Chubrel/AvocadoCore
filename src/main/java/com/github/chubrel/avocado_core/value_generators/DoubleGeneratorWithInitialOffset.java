package com.github.chubrel.avocado_core.value_generators;

public class DoubleGeneratorWithInitialOffset implements DoubleGenerator {

    private final DoubleGenerator generator;
    private final double initialOffset;
    private boolean first = true;

    public DoubleGeneratorWithInitialOffset(DoubleGenerator generator, double initialOffset) {
        this.generator = generator;
        this.initialOffset = initialOffset;
    }

    @Override
    public double next() {
        if (first) {
            first = false;
            return initialOffset + generator.next();
        }
        return generator.next();
    }
}
