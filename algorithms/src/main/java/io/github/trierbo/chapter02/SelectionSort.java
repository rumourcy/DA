package io.github.trierbo.chapter02;

import edu.princeton.cs.algs4.In;

public class SelectionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; ++i) {
            int min = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (SortUtils.less(a[j], a[min]))
                    min = j;
            }
            SortUtils.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }
}
