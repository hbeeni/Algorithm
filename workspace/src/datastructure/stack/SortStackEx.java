/**
 * Stack을 정렬하는 함수를 만드시오.
 * (단, 하나의 Stack을 추가로 사용할 수 있고,
 * Array 등 다른 데이터 구조는 사용할 수 없음)
 *
 * ex)
 * 6    1
 * 1 -> 3
 * 5    5
 * 3    6
 */

package datastructure.stack;

public class SortStackEx {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(6);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void sort(Stack<Integer> stack1) {
        Stack<Integer> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            int pop = stack1.pop();

            while (!stack2.isEmpty() && stack2.peek() > pop) {
                stack1.push(stack2.pop());
            }

            stack2.push(pop);
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
