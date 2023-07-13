package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> a * 10 + b);
    }

    public List<Integer> oddOrEven(List<Integer> integers) {
        int oddUnitsNumber = (int) integers.stream()
                .filter(e -> e % 2 != 0)
                .count();
        if (oddUnitsNumber % 2 == 0) {
            return integers.stream()
                    .filter(e -> e % 2 != 0)
                    .collect(Collectors.toList());
        } else {
            return integers.stream()
                    .filter(e -> e % 2 == 0)
                    .collect(Collectors.toList());
        }
    }
}
