package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * quick-union
 */
public class QuickUnion implements UF {

    private int[] id;
    private int N;

    public QuickUnion(int N) {
        this.N = N;
        id = new int[N];
        for (int i = 0; i < N; ++i)
            id[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);

        if (idp == idq) return;

        id[idp] = idq;
        --N;
    }

    @Override
    public int find(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return N;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new QuickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}
