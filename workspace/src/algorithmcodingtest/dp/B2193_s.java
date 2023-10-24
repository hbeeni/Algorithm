package algorithmcodingtest.dp;

import java.util.Scanner;

public class B2193_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 1][2];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            //i번째 0으로 끝나는 개수: 이전 단계의 0과 1로 끝나는 모든 경우의 수에 붙일 수 있음
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            //i번째 1로 끝나는 개수: 이전 단계의 0으로 끝나는 경우만 붙일 수 있음
            dp[i][1] = dp[i - 1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
