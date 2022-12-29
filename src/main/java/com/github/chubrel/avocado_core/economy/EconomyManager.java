package com.github.chubrel.avocado_core.economy;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class EconomyManager {

    private static @Nullable EconomyManager instance;

    private final @NotNull Map<String, NamedEconomy> economyMap = new HashMap<>();

    private EconomyManager() {}

    public static @NotNull EconomyManager instance() {
        if (instance == null)
            instance = new EconomyManager();
        return instance;
    }

    public @Nullable NamedEconomy get(@NotNull String economyName) {
        return economyMap.get(economyName);
    }

    public boolean forceRegister(@NotNull NamedEconomy economy) {
        economyMap.put(economy.economyName(), economy);
        return true;
    }

    public boolean register(@NotNull NamedEconomy economy) {
        var registeredEconomy = get(economy.economyName());
        if (registeredEconomy != null)
            return false;
        return forceRegister(economy);
    }

    public boolean unregister(@NotNull String economyName) {
        var registeredEconomy = get(economyName);
        if (registeredEconomy == null)
            return false;
        economyMap.remove(economyName);
        return true;
    }

    public boolean unregister(@NotNull NamedEconomy economy) {
        var registeredEconomy = get(economy.economyName());
        if (registeredEconomy != economy)
            return false;
        return unregister(economy.economyName());
    }
}
