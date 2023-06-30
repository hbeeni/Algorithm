/**
 * 두 개의 Stack으로 하나의 Queue를 구현하시오.
 */

package datastructure.queue;

import datastructure.stack.Stack;

public class TwoStackQueueEx<T> {

    Stack<T> stack1;
    Stack<T> stack2;

    public TwoStackQueueEx() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(T data) {
        stack1.push(data);
    }

    public T remove() {
        toStack2();
        T data = stack2.pop();
        toStack1();

        return data;
    }

    public T peek() {
        toStack2();
        T data = stack2.peek();
        toStack1();

        return data;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    private void toStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    private void toStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
