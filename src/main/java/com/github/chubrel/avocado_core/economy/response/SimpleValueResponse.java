package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public class SimpleValueResponse<V> extends SimpleResponse implements ValueResponse<V> {

    private final @NotNull V value;

    public SimpleValueResponse(boolean isFailure, @NotNull V value) {
        super(isFailure);
        this.value = value;
    }

    public SimpleValueResponse(@NotNull Exception exception, @NotNull V value) {
        super(exception);
        this.value = value;
    }

    @Override
    public @NotNull V value() {
        return value;
    }
}
