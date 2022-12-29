package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public class MultiResponse implements Response {

    private final @NotNull Response @NotNull [] responses;

    public MultiResponse(@NotNull Response @NotNull ... responses) {
        this.responses = responses;
    }

    public @NotNull Response @NotNull [] responses() {
        return responses;
    }

    public boolean isFailure() {
        for (var response : responses)
            if (response.isFailure())
                return true;
        return false;
    }

    public boolean isException() {
        for (var response : responses)
            if (response.isException())
                return true;
        return false;
    }

    @Override
    public @NotNull Exception error() throws IllegalStateException {
        for (var response : responses)
            if (response.isFailure())
                return response.error();
        throw new IllegalStateException("No errors in responses");
    }
}
