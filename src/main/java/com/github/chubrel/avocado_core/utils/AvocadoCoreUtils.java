package com.github.chubrel.avocado_core.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AvocadoCoreUtils {

    private static final @NotNull Random random = new Random();

    public static <T> T getRandomOne(@NotNull List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    public static <T> T getRandomOne(@NotNull Collection<T> collection) {
        return getRandomOne(new ArrayList<>(collection));
    }

    public static <T> T getNextElementCyclic(T element, @NotNull List<T> list) {
        return list.get((list.indexOf(element) + 1) % list.size());
    }
}
