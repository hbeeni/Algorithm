package datastructure.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T data = top.data;
        top = top.next; //다음 노드를 top으로 만들기
        return data;
    }

    public void push(T data) {
        Node<T> t = new Node<>(data);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
