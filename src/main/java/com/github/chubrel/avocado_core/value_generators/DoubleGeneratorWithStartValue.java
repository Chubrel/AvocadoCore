package com.github.chubrel.avocado_core.value_generators;

public class DoubleGeneratorWithStartValue implements DoubleGenerator {

    private final DoubleGenerator generator;
    private final double startValue;
    private boolean first = true;

    public DoubleGeneratorWithStartValue(DoubleGenerator generator, double startValue) {
        this.generator = generator;
        this.startValue = startValue;
    }

    @Override
    public double next() {
        if (first) {
            first = false;
            return startValue;
        }
        return generator.next();
    }
}
