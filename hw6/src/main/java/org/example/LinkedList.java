package org.example;

public class LinkedList {
    private Node root;

    public LinkedList() {
    }

    public void add(Object item) {
        Node newNode = new Node(item);
        Node lastNode = findLast();
        if (lastNode == null) {
            root = newNode;
        } else {
            lastNode.setNext(newNode);
        }
    }

    private Node findLast() {
        if (root == null) {
            return null;
        } else {
            Node last = root;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            return last;
        }
    }

    public Object get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть отрицательным: " + index);
        }
        Node node = root;
        for (int i = 0; i < index; i++) {
            if (node == null) {
                throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
            }
            node = node.getNext();
        }
        if (node == null) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return node.getValue();
    }

    public int size() {
        int count = 0;
        Node node = root;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }
}

class Node {
    private Object value;
    private Node next;

    public Node(Object value) {
        this.value = value;
        this.next = null;
    }

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
