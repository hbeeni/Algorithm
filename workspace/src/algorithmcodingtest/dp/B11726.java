package algorithmcodingtest.dp;

import java.util.Scanner;

public class B11726 {
    public static void main(String[] args) {
        final int MOD = 10007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
        } else {
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }

            System.out.println(dp[n]);
        }
    }
}
