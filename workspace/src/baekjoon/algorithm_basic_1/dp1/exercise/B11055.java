//https://fbtmdwhd33.tistory.com/77

package baekjoon.algorithm_basic_1.dp1.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = a[i];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(a[i] + dp[j], dp[i]);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
