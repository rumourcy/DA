package io.github.trierbo.chapter02;

public class InsertionSort {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0 && SortUtils.less(a[j], a[j-1]); --j) {
                SortUtils.exch(a, j, j-1);
            }
        }
    }
}
