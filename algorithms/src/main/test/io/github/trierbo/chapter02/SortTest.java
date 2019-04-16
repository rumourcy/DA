package io.github.trierbo.chapter02;

import edu.princeton.cs.algs4.In;

public class SortTest {
    public static void main(String[] args) {
        String[] a = In.readStrings();
        InsertionSort.sort(a);
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }
}
