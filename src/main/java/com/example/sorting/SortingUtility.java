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

        // TODO implement Cocktail Shaker Sort here
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





