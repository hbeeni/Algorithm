package algorithmcodingtest.dp;

import java.util.Scanner;

public class B2747_TopDown {

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
        fibo(n);
        System.out.println(dp[n]);
    }

    private static int fibo(int n) {
        if (dp[n] != -1) { //기존에 계산한 적이 있는 부분의 문제는 재계산하지 않고 리턴
            return dp[n];
        }
        //메모이제이션: 구한 값을 바로 리턴하지 않고 dp 테이블에 저장한 후 리턴하도록 로직을 구현
        return dp[n] = fibo(n - 2) + fibo(n - 1);
    }
}
