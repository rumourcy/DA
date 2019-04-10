package io.github.trierbo.chapter01;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > key)
                hi = mid - 1;
            else if (a[mid] < key)
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
