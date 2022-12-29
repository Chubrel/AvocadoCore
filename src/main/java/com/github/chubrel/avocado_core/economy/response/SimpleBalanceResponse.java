package com.github.chubrel.avocado_core.economy.response;

import org.jetbrains.annotations.NotNull;

public class SimpleBalanceResponse<E, B, D> extends SimpleValueResponse<E> implements BalanceResponse<E, B, D> {

    private final @NotNull B initialBalance;
    private final @NotNull D balanceDifference;
    private final @NotNull B finalBalance;

    public SimpleBalanceResponse(boolean isFailure, @NotNull E value, @NotNull B initialBalance, @NotNull D balanceDifference, @NotNull B finalBalance) {
        super(isFailure, value);
        this.initialBalance = initialBalance;
        this.balanceDifference = balanceDifference;
        this.finalBalance = finalBalance;
    }

    public SimpleBalanceResponse(@NotNull Exception exception, @NotNull E value, @NotNull B initialBalance, @NotNull D balanceDifference, @NotNull B finalBalance) {
        super(exception, value);
        this.initialBalance = initialBalance;
        this.balanceDifference = balanceDifference;
        this.finalBalance = finalBalance;
    }

    @Override
    public @NotNull B initialBalance() {
        return initialBalance;
    }

    @Override
    public @NotNull D balanceDifference() {
        return balanceDifference;
    }

    @Override
    public @NotNull B finalBalance() {
        return finalBalance;
    }
}
