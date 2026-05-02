package com.example.sorting;

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

        // TODO implement Shell Sort here
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





