//https://lotuslee.tistory.com/90
//https://jellyinghead.tistory.com/21

package baekjoon.algorithm_basic_1.dp1.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 0행 - 나를 포함한 현재까지의 수열에서 수를 제거하지 않은 경우의 최대값
         * 1행
         * - 나를 포함한 현재까지의 수열에서 수를 제거한 경우의 최대값
         * - 나를 제거하는 경우 : 이 때까지 제거한 적이 없어야 함
         *    -> 수를 제거하지 않은 경우의 최대값 = 0행의 이전열 = dp[0][i - 1]
         * - 이미 앞에서 제거한 경우 : 1행의 이전열 + 나
         *    -> 수를 제거한 경우의 최대값 + 나 = 1행의 이전열 + 나 = dp[1][i - 1] + a[i]
         */
        int[][] dp = new int[2][n];
        int max = a[0];
        dp[0][0] = a[0];
        dp[1][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + a[i], a[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + a[i]);
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(max);
    }
}
