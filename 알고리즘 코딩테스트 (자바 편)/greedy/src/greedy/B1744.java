package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        Queue<Integer> negative = new LinkedList<>();
        Stack<Integer> positive = new Stack<>();
        boolean zero = false;

        for (int i : a) {
            if (i < 0) {
                negative.add(i);
            } else if (i > 0) {
                positive.push(i);
            } else {
                zero = true;
            }
        }

        int answer = 0;

        while (positive.size() >= 2 && positive.peek() != 1) {
            int bigger = positive.pop();
            int smaller = positive.pop();

            if (smaller == 1) {
                answer += bigger + smaller;
                break;
            }

            answer += bigger * smaller;
        }
        while (!positive.isEmpty()) {
            answer += positive.pop();
        }

        while (negative.size() >= 2) {
            answer += negative.poll() * negative.poll();
        }
        if (!negative.isEmpty()) {
            answer += zero ? 0 : negative.poll();
        }

        System.out.println(answer);
    }
}
