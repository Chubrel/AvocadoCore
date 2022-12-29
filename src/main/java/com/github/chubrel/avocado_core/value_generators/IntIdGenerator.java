package com.github.chubrel.avocado_core.value_generators;

public class IntIdGenerator implements IntGenerator {

    private int id;

    public IntIdGenerator(int start) {
        id = start;
    }

    @Override
    public int next() {
        return id++;
    }
}
