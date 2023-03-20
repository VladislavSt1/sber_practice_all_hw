package org.example;

public class LinkedListGen<T> {
    private Node<T> root;

    public LinkedListGen() {
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> lastNode = findLast();
        if (lastNode == null) {
            root = newNode;
        } else {
            lastNode.setNext(newNode);
        }
    }

    private Node<T> findLast() {
        if (root == null) {
            return null;
        } else {
            Node<T> last = root;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            return last;
        }
    }

    public T get(int index) {
        Node<T> node = getNode(index);
        return node != null ? node.getValue() : null;
    }

    public int size() {
        int count = 0;
        Node<T> current = root;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
