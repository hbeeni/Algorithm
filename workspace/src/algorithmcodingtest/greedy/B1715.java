package algorithmcodingtest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while (queue.size() > 2) {
            Integer num1 = queue.poll();
            Integer num2 = queue.poll();

            sum += num1 + num2;
            queue.add(num1 + num2);
        }

        if (queue.size() == 1) {
            System.out.println(0);
        } else {
            System.out.println(sum + queue.poll() + queue.poll());
        }
    }
}
