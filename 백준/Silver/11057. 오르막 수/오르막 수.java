import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 10007;
        int n = sc.nextInt();
        sc.close();

        int[][] dp = new int[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        int answer = 0;
        for (int num : dp[n]) {
            answer += num;
        }
        System.out.println(answer % mod);
    }
}