// int형 고정 길이 큐(링 버퍼를 사용하지 않고 구현)

package queue.problem;

public class IntArrayQueue {

    private int[] que;
    private int capacity;
    private int num; //현재 데이터 개수

    public class EmptyIntArrayQueueException extends RuntimeException {
        public EmptyIntArrayQueueException() { }
    }

    public class OverflowIntArrayQueueException extends RuntimeException {
        public OverflowIntArrayQueueException() { }
    }

    public IntArrayQueue(int maxLen) {
        num = 0;
        capacity = maxLen;

        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) {
        if (num >= capacity) {
            throw new OverflowIntArrayQueueException();
        }

        que[num++] = x;
        return x;
    }

    public int deque() {
        if (num <= 0) {
            throw new EmptyIntArrayQueueException();
        }

        int x = que[0];
        for (int i = 0; i < num - 1; i++) {
            que[i] = que[i + 1];
        }
        num--;

        return x;
    }

    public int peek() { //맨 앞 데이터(다음에 deque할 데이터)
        if (num <= 0) {
            throw new EmptyIntArrayQueueException();
        }

        return que[0];
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (que[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public void clear() {
        num = 0;
    }

    public int capacity() {
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

    public void dump() { //앞 -> 뒤
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
        }
    }
}
