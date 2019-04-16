package io.github.trierbo.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {

    private Item[] items;
    private int size;

    public FixedCapacityStack(int cap) {
        items = (Item[]) new Object[cap];
        size = 0;
    }

    public void push(Item item) {
        items[size++] = item;
    }

    public Item pop() {
        return items[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> items = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                items.push(item);
            else
                StdOut.print(items.pop());
        }
        StdOut.println("(" + items.size() + " left on stack)");
    }
}
