package com.github.chubrel.avocado_core.economy;

import com.github.chubrel.avocado_core.economy.response.BalanceResponse;
import com.github.chubrel.avocado_core.economy.response.MultiResponse;
import com.github.chubrel.avocado_core.economy.response.SimpleBalanceResponse;
import org.jetbrains.annotations.NotNull;

public interface IntegerEconomy<E> extends SimplifiedEconomy<E, Integer> {

    @Override
    default boolean hasBalance(@NotNull E entity, @NotNull Integer balance)  {
        return balance(entity) >= balance;
    }

    @Override
    default @NotNull BalanceResponse<E, Integer, Integer> addBalance(@NotNull E entity, @NotNull Integer difference) {
        return setBalance(entity, balance(entity) + difference);
    }

    @Override
    default @NotNull BalanceResponse<E, Integer, Integer> takeBalance(@NotNull E entity, @NotNull Integer difference) {
        return addBalance(entity, -difference);
    }

    @Override
    default @NotNull BalanceResponse<E, Integer, Integer> takeBalanceIfEnough(@NotNull E entity, @NotNull Integer difference) {
        int balance = balance(entity);
        if (balance >= difference)
            return takeBalance(entity, difference);
        return new SimpleBalanceResponse<>(true, entity, balance, -difference, balance - difference);
    }

    @Override
    default @NotNull MultiResponse transferBalanceIfEnough(@NotNull E from, @NotNull E to, @NotNull Integer difference) {
        return new MultiResponse(takeBalanceIfEnough(from, difference), addBalance(to, difference));
    }
}
