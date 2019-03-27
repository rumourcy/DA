package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

    private String[] items;
    private int size;

    public FixedCapacityStackOfStrings(int cap) {
        items = new String[cap];
        size = 0;
    }

    public void push(String item) {
        items[size++] = item;
    }

    public String pop() {
        return items[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                fixedCapacityStackOfStrings.push(item);
            else if (!fixedCapacityStackOfStrings.isEmpty())
                StdOut.print(fixedCapacityStackOfStrings.pop() + " ");
        }
        StdOut.println("(" + fixedCapacityStackOfStrings.size() + " left on stack)");
    }

}
