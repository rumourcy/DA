package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private Node head;
    private int N;

    private class Node {
        T item;
        Node next;
    }

    private class BagIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public void add(T item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        ++N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    public static void main(String[] args) {
        Bag<String> stringBag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            stringBag.add(s);
        }
        for (String s: stringBag)
            StdOut.print(s + " ");
    }
}
