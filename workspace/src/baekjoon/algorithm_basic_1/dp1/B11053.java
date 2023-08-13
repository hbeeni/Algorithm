//https://propercoding.tistory.com/42

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; //모든 dp값들은 최소 1
        }

        /**
         * a  10 20 10 30 20 50
         * dp 1
         * dp 1  2 -> 20보다 작거나 같은 이전 원소들 중 가장 큰 dp값 + 1
         * dp 1  2  2
         * dp ...
         * 현재 dp 값 = 작거나 같은 이전 원소들 중 가장 큰 dp 값 + 1
         */
        int max = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //이전 원소들을 돌면서 현재 원소보다 클 때 dp 값 비교
                }
            }
            max = Math.max(max, dp[i]); //LIS 길이 구하기
        }

        System.out.println(max);
    }
}
