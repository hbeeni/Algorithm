// int형 고정 길이 스택의 사용 예(IntStack클래스의 모든 메서드 를 사용)

package stack.problem;

import stack.IntStack;

public class P1 {
    public static void main(String[] args) {
        IntStack stack = new IntStack(5);
        System.out.println("capacity: " + stack.getCapacity());
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(9);
        stack.dump();

        System.out.println("full? " + stack.isFull());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        stack.dump();
        System.out.println("peek: " + stack.peek());
        System.out.println("indexOf(2): " + stack.indexOf(2));
        System.out.println("indexOf(7): " + stack.indexOf(7));
        System.out.println("size: " + stack.size());
        System.out.println("empty? " + stack.isEmpty());
        System.out.println("stack.clear()");
        stack.clear();
        stack.dump();
    }
}
