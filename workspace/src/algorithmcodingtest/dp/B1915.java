//오답

package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                a[i][j] = chars[j] - '0';
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], a[i][0]);
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], a[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] == 1 && a[i][j - 1] == 1 && a[i - 1][j] == 1 && a[i - 1][j - 1] == 1) {
                    if (dp[i][j - 1] == dp[i - 1][j] && dp[i - 1][j] == dp[i - 1][j - 1]) {
                        int value = dp[i][j - 1];
                        dp[i][j] = a[i - value][j] == 1 && a[i][j - value] == 1 ? value + 1 : value;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1])));
                }
            }
        }

        int length = dp[n - 1][m - 1];
        System.out.println(length * length);
    }
}
