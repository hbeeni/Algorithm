package stack_queue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(a[i]);
            } else {
                result[i] = stack.peek();
                stack.push(a[i]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            bw.write(i + " ");
        }

        bw.flush();
    }
}
