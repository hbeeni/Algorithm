//Do it! 코딩 테스트 - 자바 편 205p

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1744_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) { //4개 그룹으로 분리해서 저장
            int data = Integer.parseInt(br.readLine());

            if (data == 0) {
                zero++;
            } else if (data == 1) {
                one++;
            } else if (data > 1) {
                plusPq.add(data);
            } else {
                minusPq.add(data);
            }
        }

        int sum = 0;
        //양수 처리
        while (plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }
        if (!plusPq.isEmpty()) {
            sum += plusPq.remove();
        }

        //음수 처리
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += first * second;
        }
        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum += minusPq.remove();
            }
        }

        //1 처리
        sum += one;

        System.out.println(sum);
    }
}
