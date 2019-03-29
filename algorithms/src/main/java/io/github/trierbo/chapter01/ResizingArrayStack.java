package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T> {

    private int size = 0;
    private T[] items = (T[]) new Object[1];

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return items[--i];
        }
    }

    private void resize(int max) {
        T[] tmp = (T[]) new Object[max];
        if (size >= 0)
            System.arraycopy(items, 0, tmp, 0, size);
        items = tmp;
    }

    public void push(T item) {
        if (size == items.length)
            resize(items.length * 2);
        items[size++] = item;
    }

    public T pop() {
        T tmp = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length / 4)
            resize(items.length / 2);
        return tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.println(stack.pop() + " ");
        }
        StdOut.println();
        for (String s: stack)
            StdOut.print(s + " ");
    }

}
