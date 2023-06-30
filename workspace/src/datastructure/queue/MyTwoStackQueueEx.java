/**
 * 두 개의 Stack으로 하나의 Queue를 구현하시오.
 * by 엔지니어 대한민국
 */

package datastructure.queue;

import datastructure.stack.Stack;

public class MyTwoStackQueueEx<T> {

    Stack<T> stackNewest, stackOldest;

    public MyTwoStackQueueEx() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public void add(T data) {
        stackNewest.push(data);
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
