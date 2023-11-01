package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1915_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //dp[i][j] = i, j의 위치를 오른쪽 아래 꼭짓점으로 정하고, 해당 자리에서 그릴 수 있는 가장 큰 정사각형의 변의 길이
        long[][] dp = new long[n + 1][m + 1];
        long max = 0;
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dp[i][j] = chars[j] - '0';
                if (dp[i][j] == 1 && j > 0 && i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        for (long[] longs : dp) {
            System.out.println(Arrays.toString(longs));
        }
        System.out.println(max * max);
    }
}
