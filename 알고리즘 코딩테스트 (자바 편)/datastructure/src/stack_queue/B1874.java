//BufferedWriter 사용 시 출력초과 발생 -> StringBuffer 쓰니까 맞음

package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        stack.add(1);
        sb.append("+");

        int i;
        int num = 2;
        for (i = 0; i < n; i++) {
            int current = a[i];

            if (stack.isEmpty()) {
                stack.add(num++);
                sb.append("\n+");
            }
            if (current > stack.peek()) {
                while (current != stack.peek()) {
                    stack.add(num++);
                    sb.append("\n+");
                }
            } else if (current < stack.peek()) {
                break;
            }
            if (current == stack.peek()) {
                stack.pop();
                sb.append("\n-");
            }
        }

        if (i != n) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
