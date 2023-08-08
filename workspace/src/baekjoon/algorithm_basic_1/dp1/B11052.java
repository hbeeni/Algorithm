//https://smartpro.tistory.com/53

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        int[] d = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 카드 4개일 때
         * 1. 카드를 하나도 안 산 상태(d[0])에서 카드가 4개 들어있는 카드팩 p4 구매
         *    -> d[4] = d[0] + p[4]
         * 2. d[1]에서 카드 3개 더 구매
         *    -> d[4] = d[1] + p[3]
         * 3. d[2]에서 카드 2개 더 구매
         *    -> d[4] = d[2] + p[2]
         * 4. d[3]에서 카드 1개 더 구매
         *    -> d[4] = d[3] + p[1]
         * ---------------------------------------
         * d[i] = d[i - 4] + p[4]
         * d[i] = d[i - 3] + p[3]
         * d[i] = d[i - 2] + p[2]
         * d[i] = d[i - 1] + p[1]
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + p[j]);
            }
        }

        System.out.println(d[n]);
    }
}
