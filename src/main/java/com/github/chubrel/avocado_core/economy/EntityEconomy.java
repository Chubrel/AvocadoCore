package com.github.chubrel.avocado_core.economy;

import com.github.chubrel.avocado_core.economy.response.AccountCreationResponse;
import com.github.chubrel.avocado_core.economy.response.AccountDeletionResponse;
import org.jetbrains.annotations.NotNull;

public interface EntityEconomy<E> {

    @NotNull AccountCreationResponse createAccount(@NotNull E entity);

    boolean hasAccount(@NotNull E entity);

    @NotNull AccountDeletionResponse deleteAccount(@NotNull E entity);
}
