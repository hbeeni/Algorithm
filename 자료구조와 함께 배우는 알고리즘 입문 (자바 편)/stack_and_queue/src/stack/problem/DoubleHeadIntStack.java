package stack.problem;

public class DoubleHeadIntStack {

    private int[] stk;
    private int capacity;
    private int ptrA;
    private int ptrB;

    public enum AorB {
        StackA, StackB
    }

    public class EmptyDoubleHeadIntStackException extends RuntimeException {
        public EmptyDoubleHeadIntStackException() { }
    }

    public class OverflowDoubleHeadIntStackException extends RuntimeException {
        public OverflowDoubleHeadIntStackException() { }
    }

    public DoubleHeadIntStack(int maxLen) {
        ptrA = 0;
        ptrB = maxLen - 1;
        capacity = maxLen;

        try {
            stk = new int[maxLen];
        } catch (OutOfMemoryError error) {
            capacity = 0;
        }
    }

    public int push(AorB sw, int x) {
        if (ptrA >= ptrB + 1) {
            throw new OverflowDoubleHeadIntStackException();
        }

        switch (sw) {
            case StackA:
                stk[ptrA++] = x;
                break;

            case StackB:
                stk[ptrB--] = x;
        }

        return x;
    }

    public int pop(AorB sw) {
        int x = 0;

        switch (sw) {
            case StackA:
                if (ptrA <= 0) {
                    throw new EmptyDoubleHeadIntStackException();
                }

                x = stk[--ptrA];
                break;

            case StackB:
                if (ptrB >= capacity - 1) {
                    throw new EmptyDoubleHeadIntStackException();
                }

                x = stk[++ptrB];
        }

        return x;
    }

    public int peek(AorB sw) {
        int x = 0;

        switch (sw) {
            case StackA:
                if (ptrA <= 0) {
                    throw new EmptyDoubleHeadIntStackException();
                }

                x = stk[ptrA - 1];
                break;

            case StackB:
                if (ptrB >= capacity - 1) {
                    throw new EmptyDoubleHeadIntStackException();
                }

                x = stk[ptrB + 1];
        }

        return x;
    }

    public int indexOf(AorB sw, int x) {
        switch (sw) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--) {
                    if (stk[i] == x) {
                        return i;
                    }
                }

                break;

            case StackB:
                for (int i = ptrB + 1; i < capacity; i++) {
                    if (stk[i] == x) {
                        return i;
                    }
                }
        }

        return -1;
    }

    public void clear(AorB sw) {
        switch (sw) {
            case StackA:
                ptrA = 0;
                break;

            case StackB:
                ptrB = capacity - 1;
        }
    }

    //스택 용량(A, B 합계) 반환
    public int getCapacity() {
        return capacity;
    }

    public int size(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA;

            case StackB:
                return capacity - ptrB - 1;
        }

        return 0;
    }

    public boolean isEmpty(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA <= 0;

            case StackB:
                return ptrB >= capacity - 1;
        }

        return true;
    }

    public boolean isFull() {
        return ptrA >= ptrB + 1;
    }

    public void dump(AorB sw) { //바닥 -> 꼭대기
        switch (sw) {
            case StackA:
                if (ptrA <= 0) {
                    System.out.println("스택A가 비어있습니다.");
                } else {
                    for (int i = 0; i < ptrA; i++) {
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;

            case StackB:
                if (ptrB >= capacity - 1) {
                    System.out.println("스택B가 비어있습니다.");
                } else {
                    for (int i = capacity - 1; i > ptrB; i--) {
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
        }
    }
}
