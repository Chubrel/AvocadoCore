package com.github.chubrel.avocado_core.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class AvocadoCoreUtils {

    private static final @NotNull Random random = new Random();

    public static <T> @Nullable T getOne(@NotNull Collection<@Nullable T> collection) {
        for (T element : collection)
            return element;
        throw new IllegalArgumentException("No elements in the collection");
    }

    @SafeVarargs
    public static <T> @Nullable T getRandomOne(@Nullable T @NotNull ... array) {
        return array[random.nextInt(array.length)];
    }

    public static <T> @Nullable T getRandomOne(@NotNull List<@Nullable T> list) {
        return list.get(random.nextInt(list.size()));
    }

    public static <T> @Nullable T getRandomOne(@NotNull Collection<@Nullable T> collection) {
        return getRandomOne(new ArrayList<>(collection));
    }

    public static <T> @Nullable T getNextElementCyclic(T element, @NotNull List<@Nullable T> list) {
        return list.get((list.indexOf(element) + 1) % list.size());
    }
}
