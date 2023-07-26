//https://mslim8803.tistory.com/11

package baekjoon.algorithm_basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /**
         * 분자, 분모를 소인수 분해 했을 때
         * 분자 2 개수 - 분모 2 개수, 분자 5 개수 - 분모 5 개수 중 작은 값이 답이 됨
         * -> 2 * 5 = 10인데 작은 개수 만큼 10이 만들어지기 때문
         */
        long count2 = getCount(n, 2) - getCount(m, 2) - getCount(n - m, 2);
        long count5 = getCount(n, 5) - getCount(m, 5) - getCount(n - m, 5);

        System.out.println(Math.min(count2, count5));
    }

    /**
     * ex) 59!
     * 5의 배수는 59 / 5 = 11개, 55 X 50 X 45 ... 10 X 5
     * -> 최소한 11개의 5를 소인수로 가지고 있음
     * 각각의 11개의 수들을 5로 나눠보면, 11 X 10 X 9 X ... X 2 X 1
     * -> 5의 배수의 개수는 11 / 5 = 2개
     * => 총 13개
     */
    private static long getCount(int num, int k) {
        long count = 0;
        while (num >= k) {
            count += num / k;
            num /= k;
        }
        return count;
    }
}
