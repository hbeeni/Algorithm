//제네릭 큐

package queue.problem;

public class Queue<E> {

    private E[] que;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public static class EmptyGqueueException extends RuntimeException {
        public EmptyGqueueException() { }
    }

    public static class OverflowGqueueException extends RuntimeException {
        public OverflowGqueueException() { }
    }

    public Queue(int maxLen) {
        num = front = rear = 0;
        capacity = maxLen;

        try {
            que = (E[]) new Object[maxLen];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public E enque(E e) {
        if (num >= capacity) {
            throw new OverflowGqueueException();
        }

        que[rear++] = e;
        num++;

        if (rear >= capacity) {
            rear = 0;
        }

        return e;
    }

    public E deque() {
        if (num <= 0) {
            throw new EmptyGqueueException();
        }

        E e = que[front++];
        num--;

        if (front >= capacity) {
            front = 0;
        }

        return e;
    }

    public E peek() { //맨 앞 데이터(다음에 deque할 데이터)
        if (num <= 0) {
            throw new EmptyGqueueException();
        }

        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(E e) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;

            if (que[idx].equals(e)) {
                return idx;
            }
        }

        return -1;
    }

    //P5
    public int search(E e) { //큐 안에서 몇 번째에 있는지
        for (int i = 0; i < num; i++) {
            if (que[(i + front) % capacity].equals(e)) {
                return i + 1;
            }
        }

        return 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}
