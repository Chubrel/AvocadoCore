package com.github.chubrel.avocado_core.economy;

import org.jetbrains.annotations.NotNull;

public interface FullEconomy<E, B, D> extends SampleEconomy<E, B, D> {

    @NotNull String formatBalanceDifference(@NotNull D difference);
}
