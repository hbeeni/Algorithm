//https://zoonvivor.tistory.com/152

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = a[0];
        int max = a[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]); //이전부터 계속 연속한 값 vs 현재부터 연속된 값
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
