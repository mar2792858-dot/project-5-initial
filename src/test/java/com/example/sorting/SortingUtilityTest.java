package com.example.sorting;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Data-driven tests for sorting algorithms.
 * Shared datasets are applied to all algorithms to reduce duplication while keeping coverage.
 */
class SortingUtilityTest {

    @FunctionalInterface
    private interface Sorter<T extends Comparable<T>> {
        void sort(T[] a);
    }

    private record IntegerCase(String name, Integer[] input, Integer[] expected) {
    }

    private record StringCase(String name, String[] input, String[] expected) {
    }

    private record IntegerAlgorithm(String name, Sorter<Integer> sorter) {
    }

    private record StringAlgorithm(String name, Sorter<String> sorter) {
    }

    private static Stream<IntegerAlgorithm> integerAlgorithms() {
        return Stream.of(
                new IntegerAlgorithm("gnomeSort", SortingUtility::gnomeSort),
                new IntegerAlgorithm("cocktailShakerSort", SortingUtility::cocktailShakerSort),
                new IntegerAlgorithm("shellSort", SortingUtility::shellSort)
        );
    }

    private static Stream<StringAlgorithm> stringAlgorithms() {
        return Stream.of(
                new StringAlgorithm("gnomeSort", SortingUtility::gnomeSort),
                new StringAlgorithm("cocktailShakerSort", SortingUtility::cocktailShakerSort),
                new StringAlgorithm("shellSort", SortingUtility::shellSort)
        );
    }

    private static List<IntegerCase> integerCases() {
        return List.of(
                new IntegerCase("empty array", new Integer[]{}, new Integer[]{}),
                new IntegerCase("single element", new Integer[]{5}, new Integer[]{5}),
                new IntegerCase("already sorted", new Integer[]{1, 2, 3, 4, 5}, new Integer[]{1, 2, 3, 4, 5}),
                new IntegerCase("reverse sorted", new Integer[]{5, 4, 3, 2, 1}, new Integer[]{1, 2, 3, 4, 5}),
                new IntegerCase("duplicates", new Integer[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3}, new Integer[]{1, 1, 2, 3, 3, 4, 5, 5, 6, 9}),
                new IntegerCase("all same elements", new Integer[]{5, 5, 5, 5, 5}, new Integer[]{5, 5, 5, 5, 5}),
                new IntegerCase("two elements swapped", new Integer[]{2, 1}, new Integer[]{1, 2}),
                new IntegerCase("two elements sorted", new Integer[]{1, 2}, new Integer[]{1, 2}),
                new IntegerCase("random order", new Integer[]{64, 34, 25, 12, 22, 11, 90}, new Integer[]{11, 12, 22, 25, 34, 64, 90}),
                new IntegerCase("negatives and zero mix", new Integer[]{-3, 0, -1, 2, -2}, new Integer[]{-3, -2, -1, 0, 2})
        );
    }

    private static List<StringCase> stringCases() {
        return List.of(
                new StringCase("string example", new String[]{"zebra", "apple", "mango", "banana"}, new String[]{"apple", "banana", "mango", "zebra"}),
                new StringCase("empty array", new String[]{}, new String[]{}),
                new StringCase("single element", new String[]{"apple"}, new String[]{"apple"}),
                new StringCase("duplicates", new String[]{"dog", "cat", "dog", "apple", "cat"}, new String[]{"apple", "cat", "cat", "dog", "dog"}),
                new StringCase("reverse ordered", new String[]{"zebra", "mango", "apple"}, new String[]{"apple", "mango", "zebra"})
        );
    }

    @TestFactory
    Stream<DynamicTest> sortsAllRequiredIntegerCases() {
        return integerAlgorithms().flatMap(algorithm ->
                integerCases().stream().map(testCase -> DynamicTest.dynamicTest(
                        algorithm.name + " - " + testCase.name,
                        () -> {
                            Integer[] arr = Arrays.copyOf(testCase.input, testCase.input.length);
                            algorithm.sorter.sort(arr);
                            assertArrayEquals(testCase.expected, arr, "Array should match expected sorted order");
                            assertTrue(isSorted(arr), "Array should be in ascending order");
                        }
                ))
        );
    }

    @TestFactory
    Stream<DynamicTest> sortsAllRequiredStringCases() {
        return stringAlgorithms().flatMap(algorithm ->
                stringCases().stream().map(testCase -> DynamicTest.dynamicTest(
                        algorithm.name + " - " + testCase.name,
                        () -> {
                            String[] arr = Arrays.copyOf(testCase.input, testCase.input.length);
                            algorithm.sorter.sort(arr);
                            assertArrayEquals(testCase.expected, arr, "Array should match expected sorted order");
                            assertTrue(isSorted(arr), "Array should be in ascending order");
                        }
                ))
        );
    }

    @Test
    void gnomeSortPosBacktrackingEdgeCase() {
        // Ensures pos can backtrack toward index 0 and continue correctly.
        Integer[] arr = {3, 1, 2};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3}, arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void gnomeSortLargeValueBeginning() {
        // Forces repeated backtracking when the first element belongs near the end.
        Integer[] arr = {5, 1, 2, 3, 4};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void cocktailShakerSortBidirectionalBehavior() {
        // Confirms forward/backward sweeps both contribute to sorting.
        Integer[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void cocktailShakerSortNearlySorted() {
        Integer[] arr = {1, 2, 3, 4, 6, 5};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void shellSortLargerArray() {
        // Verifies behavior on a size where several Ciura gaps are exercised.
        Integer[] arr = {73, 39, 81, 7, 44, 28, 12, 65, 51, 18, 94, 55, 3, 62, 37};
        SortingUtility.shellSort(arr);
        assertTrue(isSorted(arr));
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
