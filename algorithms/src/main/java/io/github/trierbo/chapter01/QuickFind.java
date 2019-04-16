package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * quick-find
 */
public class QuickFind implements UF {
    private int[] id;
    private int N;

    public QuickFind(int N) {
        this.N = N;
        id = new int[N];
        for (int i = 0; i < N; ++i)
            id[i] = i;
    }

    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);

        if (idp == idq)
            return;

        for (int i = 0; i < id.length; ++i)
            if (id[i] == idp)
                id[i] = idq;

        --N;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return N;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind quickFind = new QuickFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            quickFind.union(p, q);
            StdOut.println(p + " " + q + " " + quickFind.find(p));
        }
        StdOut.println(quickFind.count() + " components");
    }

}
