package io.github.trierbo.chapter02;

import edu.princeton.cs.algs4.StdOut;

public class SortUtils {
    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    protected static void show(Comparable[] a) {
        for (Comparable c: a)
            StdOut.print(c + " ");
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
