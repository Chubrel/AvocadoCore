package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleResponse implements Response {

    private final boolean isFailure;
    private final boolean isException;
    private final @Nullable Exception exception;

    public SimpleResponse(boolean isFailure) {
        this.isFailure = isFailure;
        this.isException = false;
        this.exception = null;
    }

    public SimpleResponse(@NotNull Exception exception) {
        this.isFailure = true;
        this.isException = true;
        this.exception = exception;
    }

    @Override
    public boolean isFailure() {
        return isFailure;
    }

    @Override
    public boolean isException() {
        return isException;
    }

    @Override
    public @NotNull Exception error() throws IllegalStateException {
        if (isException) {
            assert exception != null;
            return exception;
        }
        throw new IllegalStateException("No error in response");
    }
}
