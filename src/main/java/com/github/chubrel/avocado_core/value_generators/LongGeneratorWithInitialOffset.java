package com.github.chubrel.avocado_core.value_generators;

public class LongGeneratorWithInitialOffset implements LongGenerator {
    
    private final LongGenerator generator;
    private final long initialOffset;
    private boolean first = true;

    public LongGeneratorWithInitialOffset(LongGenerator generator, long initialOffset) {
        this.generator = generator;
        this.initialOffset = initialOffset;
    }

    @Override
    public long next() {
        if (first) {
            first = false;
            return initialOffset + generator.next();
        }
        return generator.next();
    }
}
