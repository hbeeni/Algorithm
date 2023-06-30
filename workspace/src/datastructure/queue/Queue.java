package datastructure.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T data) {
        Node<T> t = new Node<>(data);

        if (first == null) {
            first = last = t;
        } else {
            last.next = t;
            last = t;
        }
    }

    /**
     * 맨 앞에서 데이터를 하나 꺼냄
     */
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
