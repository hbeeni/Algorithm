package stack;

public class IntStack {
    private int[] stk; //스택용 배열
    private int capacity; //스택 용량
    private int ptr; //스택 포인터

    //스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    //스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStack(int maxLen) {
        ptr = 0;
        capacity = maxLen;

        try {
            stk = new int[maxLen];
        } catch (OutOfMemoryError error) { //생성할 수 없음
            capacity = 0;
        }
    }

    public int push(int x) {
        if (ptr >= capacity) {
            throw new OverflowIntStackException();
        }

        return stk[ptr++] = x;
    }

    public int pop() {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }

        return stk[--ptr];
    }

    public int peek() {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }

        return stk[ptr - 1];
    }

    public void clear() {
        ptr = 0;
    }

    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) { //먼저 pop이 되는 데이터를 찾기 위해 꼭대기부터 검색
            if (stk[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
