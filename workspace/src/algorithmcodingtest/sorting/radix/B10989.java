//시간 초과

package algorithmcodingtest.sorting.radix;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B10989 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] a = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(br.readLine());
//        }

        int[] a = {215, 15, 344, 372, 294, 100, 8, 145, 24, 198, 831};
        int n = a.length;

        PriorityQueue<Integer>[] queues = new PriorityQueue[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        int length = 0;
        for (int num : a) {
            length = Math.max(length, String.valueOf(num).length());
        }

        int value = 1;

        while (value <= length) {
            System.out.println("value = " + value);
            for (int num : a) {
                int tmp = num;
                tmp /= Math.pow(10, value - 1);
                queues[tmp % 10].add(num);
            }
            value++;

            int i = 0;
            for (PriorityQueue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    a[i++] = queue.poll();
                }
            }

            System.out.println(Arrays.toString(a));
        }

        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
