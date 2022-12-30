package com.github.chubrel.avocado_core.value_generators;

public class IntGeneratorWithInitialOffset implements IntGenerator {
    
    private final IntGenerator generator;
    private final int initialOffset;
    private boolean first = true;

    public IntGeneratorWithInitialOffset(IntGenerator generator, int initialOffset) {
        this.generator = generator;
        this.initialOffset = initialOffset;
    }

    @Override
    public int next() {
        if (first) {
            first = false;
            return initialOffset + generator.next();
        }
        return generator.next();
    }
}
