package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> a * 10 + b);
    }

    public List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> oddOrEvenNumbersMap = integers.stream()
                .collect(Collectors.partitioningBy(e -> e % 2 == 1));
        if (oddOrEvenNumbersMap.get(true).size() % 2 == 1) {
            return oddOrEvenNumbersMap.get(false);
        } else {
            return oddOrEvenNumbersMap.get(true);
        }
    }
}
