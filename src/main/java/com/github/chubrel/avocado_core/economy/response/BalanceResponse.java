package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public interface BalanceResponse<E, B, D> extends ValueResponse<E> {

    @NotNull B initialBalance();

    @NotNull D balanceDifference();

    @NotNull B finalBalance();
}
