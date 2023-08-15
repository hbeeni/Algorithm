package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;

        /**
         * 1 ~ N 까지의 수 중 제곱수인 수 + (n - 제곱수)의 최소 제곱수 개수 중 최솟값
         * ex) 13의 제곱수의 합
         * -> (13 - 1)의 최소 제곱수 합
         * -> (13 - 4)의 최소 제곱수 합
         * -> (13 - 9)의 최소 제곱수 합
         *    중 가장 작은 값 + 1(제곱수)
         */
        for (int i = 2; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int current = dp[i - j * j] + 1;
                if (dp[i] > current) {
                    dp[i] = current;
                }
            }
        }
    }
}
