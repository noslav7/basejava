package ru.javawebinar.basejava;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StreamsTest {

    @Test
    public void whenMinValueTest123323then123() {
        int[] testArray = new int[] {1,2,3,3,2,3};
        Streams stream = new Streams();
        int expected = 123;
        int actual = stream.minValue(testArray);
        assertEquals(expected, actual);
    }

    @Test
    public void whenMinValueTest98then89() {
        int[] testArray = new int[] {9, 8};
        Streams stream = new Streams();
        int expected = 89;
        int actual = stream.minValue(testArray);
        assertEquals(expected, actual);
    }

    @Test
    public void whenOddOrEvenTest357988then3579() {
        List<Integer> testList = new ArrayList<>();
        testList.add(3);
        testList.add(5);
        testList.add(7);
        testList.add(9);
        testList.add(8);
        testList.add(8);
        Streams stream = new Streams();
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(7);
        expected.add(9);
        List<Integer> actual = stream.oddOrEven(testList);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenOddOrEvenTest367988then688() {
        List<Integer> testList = new ArrayList<>();
        testList.add(3);
        testList.add(6);
        testList.add(7);
        testList.add(9);
        testList.add(8);
        testList.add(8);
        Streams stream = new Streams();
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(8);
        expected.add(8);
        List<Integer> actual = stream.oddOrEven(testList);
        Assert.assertEquals(expected, actual);
    }
}