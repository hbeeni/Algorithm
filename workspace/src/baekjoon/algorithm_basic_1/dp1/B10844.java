//https://code-lab1.tistory.com/108

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10844 {
    public static void main(String[] args) throws IOException {
        /**
         * dp[i][j] = i번째 자릿수의 값이 j일 때 계단수
         * ex) dp[3][5] = dp[2][4] + dp[2][6]
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % MOD; //자릿값이 0 -> 이전 자릿값은 1만 가능
                } else if (j == 9) { //자릿값이 9 -> 이전 자릿값 8만 가능
                    dp[i][9] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % MOD);
    }
}
