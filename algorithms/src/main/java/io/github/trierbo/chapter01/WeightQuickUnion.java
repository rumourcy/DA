package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightQuickUnion implements UF {
    private int[] id;
    private int[] sz;
    private int N;

    public WeightQuickUnion(int N) {
        this.N = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (sz[pRoot] >= sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        }
        --N;
    }

    @Override
    public int find(int p) {
        while (p != id[p])
            p = id[p];
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
        UF uf = new WeightQuickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
