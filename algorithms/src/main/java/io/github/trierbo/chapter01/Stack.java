package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node first;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    private class StackIterator implements Iterator<T> {

        private Node current = first;

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

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        ++size;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        --size;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-"))
                stringStack.push(s);
            else if (!stringStack.isEmpty())
                StdOut.print(stringStack.pop() + " ");
        }
        StdOut.println("(" + stringStack.size() + " left on the stack)");
        for (String s: stringStack)
            StdOut.print(s + " ");
    }
}
