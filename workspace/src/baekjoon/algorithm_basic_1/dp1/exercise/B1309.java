//https://steady-coding.tistory.com/156

package baekjoon.algorithm_basic_1.dp1.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 9901;
        int n = Integer.parseInt(br.readLine());

        /**
         * dp[i][j]
         * i번째 줄, j번째 칸에 사자를 놓을 수 있는 경우의 수
         * j = 0: 아무 곳에도 사자를 놓지 않음
         *
         * dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2]
         * dp[2][1] = dp[1][0] + dp[1][2]
         * dp[2][2] = dp[1][0] + dp[1][1]
         */
        long[][] dp = new long[n + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);
    }
}
