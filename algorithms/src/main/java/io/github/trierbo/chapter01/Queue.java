package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int N;

    private class Node {
        T item;
        Node next;
    }

    private class QueueIterator implements Iterator<T> {

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

    public void enqueue(T item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        if (isEmpty())
            head = tail;
        else
            oldTail.next = tail;
        ++N;
    }

    public T dequeue() {
        T item = head.item;
        head = head.next;
        if (isEmpty())
            tail = null;
        --N;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    public static void main(String[] args)
    {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");

        for (String s: q)
            StdOut.print(s + " ");
    }
}
