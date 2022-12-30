package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public class AccountDeletionResponse extends SimpleResponse {

    private final @NotNull Type type;

    public AccountDeletionResponse(@NotNull Type type) {
        super(false);
        if (type == Type.FAILURE)
            throw new IllegalArgumentException("Error must be provided for failure response");
        this.type = type;
    }

    public AccountDeletionResponse(@NotNull Exception exception) {
        super(exception);
        this.type = Type.FAILURE;
    }

    public @NotNull Type type() {
        return type;
    }

    public enum Type {
        SUCCESS,
        ALREADY_ABSENT,
        FAILURE,
    }
}
