package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2342_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //dp[n][l][r] = n번째 수열까지 진행했고, 왼쪽 다리가 l, 오른쪽 다리가 r에 있을 때 힘의 최솟값(최소 누적합)
        int[][][] dp = new int[100001][5][5];
        //mp[i][j] = 한 발을 이동할 때 드는 힘 ex) mp[1][2] = 1 -> 2로 이동할 때 드는 힘
        int[][] mp = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };

        int n = 0, s = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++) {
                    dp[k][i][j] = 100001 * 4; //충분히 큰 수로 초기화
                }
            }
        }
        dp[0][0][0] = 0;

        while (true) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            for (int i = 0; i < 5; i++) {
                if (n == i) { //두 발이 같은 자리에 있을 수 없음
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    //오른발을 옮겨 현재 모습이 됐을 때 최소 힘
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
                }
            }

            for (int j = 0; j < 5; j++) {
                if (n == j) {
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    //왼발을 옮겨 현재 모습이 됐을 때 최소 힘
                    dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
                }
            }
            s++;
        }
        s--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[s][i][j]);
            }
        }
        System.out.println(min);
    }
}
