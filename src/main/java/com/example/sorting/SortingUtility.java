package com.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] a) {

        int pos = 0;

        while (pos < a.length) {
            // Move forward when at the start of the array or already in sorted order.
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos = pos + 1;
            } else {
                // Swap out-of-order neighbors, then step backward to re-check.
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {

        boolean swapped;

        do {
            swapped = false;

            // Sweep left-to-right, swapping adjacent out-of-order elements.
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // If no swaps happened, the array is already sorted.
            if (!swapped) {
                break;
            }

            swapped = false;

            // Sweep right-to-left, again swapping adjacent out-of-order elements.
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // Ciura gap sequence stored as an ArrayList, as required by the pseudocode.
        ArrayList<Integer> gaps = new ArrayList<>(Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1));
        int n = a.length;

        // Start with the largest gap and work down to a gap of 1.
        for (int gap : gaps) {
            // Do a gapped insertion sort for each element in the current gap group.
            for (int i = gap; i < n; i += 1) {
                // Save a[i] in temp and create a hole at position i.
                T temp = a[i];
                int j;

                // Shift earlier gap-sorted elements up until temp belongs at index j.
                for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap) {
                    a[j] = a[j - gap];
                }

                // Put temp (the original a[i]) in its correct location.
                a[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





