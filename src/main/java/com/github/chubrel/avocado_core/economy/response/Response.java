package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public interface Response {

    boolean isFailure();

    boolean isException();

    @NotNull Exception error() throws IllegalStateException;
}
