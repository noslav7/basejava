package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {

    public int[] minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .toArray();
    }

    public List<Integer> oddOrEven(List<Integer> integers) {
        if (Optional.of(integers.stream()
                        .reduce(0, Integer::sum))
                .filter(e -> e % 2 == 0)
                .isPresent()) {
            return integers.stream()
                    .filter(e -> e % 2 == 0)
                    .collect(Collectors.toList());
        } else {
            return integers.stream()
                    .filter(e -> e % 2 != 0)
                    .collect(Collectors.toList());
        }
    }
}
