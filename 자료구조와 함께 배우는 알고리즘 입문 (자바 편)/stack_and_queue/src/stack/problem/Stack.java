// 제네릭 스택

package stack.problem;

public class Stack<E> {

    private E[] stk;
    private int capacity;
    private int ptr;

    public static class EmptyGstackException extends RuntimeException {
        public EmptyGstackException() { }
    }

    public static class OverflowGstackException extends RuntimeException {
        public OverflowGstackException() { }
    }

    public Stack(int maxLen) {
        ptr = 0;
        capacity = maxLen;

        try {
            stk = (E[]) (new Object[maxLen]);
        } catch (OutOfMemoryError error) { //생성할 수 없음
            capacity = 0;
        }
    }

    public E push(E e) {
        if (ptr >= capacity) {
            throw new OverflowGstackException();
        }

        return stk[ptr++] = e;
    }

    public E pop() {
        if (ptr <= 0) {
            throw new EmptyGstackException();
        }

        return stk[--ptr];
    }

    public E peek() {
        if (ptr <= 0) {
            throw new EmptyGstackException();
        }

        return stk[ptr - 1];
    }

    public void clear() {
        ptr = 0;
    }

    public int indexOf(E e) {
        for (int i = ptr - 1; i >= 0; i--) { //먼저 pop이 되는 데이터를 찾기 위해 꼭대기부터 검색
            if (stk[i].equals(e)) {
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
            System.out.println("스텍이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
