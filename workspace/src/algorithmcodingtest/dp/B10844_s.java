package algorithmcodingtest.dp;

import java.util.Scanner;

public class B10844_s {
    public static void main(String[] args) {
        final int MOD = 1_000_000_000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % MOD);
    }
}
