package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public int minValue(int[] values) {
        int[] resultInArray = Arrays.stream(values)
                .distinct()
                .sorted()
                .toArray();
        int result = 0;
        for (int i = 0; i < resultInArray.length; i++) {
            result += resultInArray[i] * (Math.pow(10, (resultInArray.length - i - 1)));
        }
        return result;
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
