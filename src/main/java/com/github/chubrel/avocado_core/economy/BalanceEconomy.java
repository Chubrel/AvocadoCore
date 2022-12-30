package com.github.chubrel.avocado_core.economy;

import org.jetbrains.annotations.NotNull;

public interface BalanceEconomy<B> {
    @NotNull String currencyName(@NotNull B balance);

    @NotNull String formatBalance(@NotNull B balance);

    @NotNull B defaultBalance();
}
