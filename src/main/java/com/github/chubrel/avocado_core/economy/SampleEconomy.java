package com.github.chubrel.avocado_core.economy;

import com.github.chubrel.avocado_core.economy.response.BalanceResponse;
import com.github.chubrel.avocado_core.economy.response.MultiResponse;
import org.jetbrains.annotations.NotNull;

public interface SampleEconomy<E, B, D> extends NamedEconomy, BalanceEconomy<B>, EntityEconomy<E> {

    @NotNull B balance(@NotNull E entity);

    boolean hasBalance(@NotNull E entity, @NotNull B balance);

    @NotNull BalanceResponse<E, B, D> setBalance(@NotNull E entity, @NotNull B balance);

    default @NotNull BalanceResponse<E, B, D> resetBalance(@NotNull E entity) {
        return setBalance(entity, defaultBalance());
    }

    @NotNull BalanceResponse<E, B, D> addBalance(@NotNull E entity, @NotNull D difference);

    @NotNull BalanceResponse<E, B, D> takeBalance(@NotNull E entity, @NotNull D difference);

    @NotNull BalanceResponse<E, B, D> takeBalanceIfEnough(@NotNull E entity, @NotNull D difference);

    default @NotNull MultiResponse transferBalance(@NotNull E from, @NotNull E to, @NotNull D difference) {
        return new MultiResponse(takeBalance(from, difference), addBalance(to, difference));
    }

    @NotNull MultiResponse transferBalanceIfEnough(@NotNull E from, @NotNull E to, @NotNull D difference);
}
