package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public interface ValueResponse<V> extends Response {

    @NotNull V value();
}
