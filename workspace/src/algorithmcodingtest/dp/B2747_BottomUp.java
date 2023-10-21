package algorithmcodingtest.dp;

import java.util.Scanner;

public class B2747_BottomUp {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
