package baekjoon.algorithm_basic_1.dp1.challenge;

import java.util.Scanner;

public class B2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int mod = 1_000_000_000;

        long[][] dp = new long[n + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] % mod + dp[i][j - 1] % mod;
            }
        }

        System.out.println(dp[n][k] % mod);
    }
}
