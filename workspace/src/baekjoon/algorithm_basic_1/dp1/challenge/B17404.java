//https://dragon-h.tistory.com/31

package baekjoon.algorithm_basic_1.dp1.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 1000 * 1000; //최대 비용 값

        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        //첫 집을 칠하는 경우: 0 -> red, 1 -> green, 2 -> blue
        for (int first = 0; first < 3; first++) {
            //각 색을 제외한 나머지는 INF로 초기화 (아예 큰 값으로 초기화해서 선택이 안되게)
            for (int j = 0; j < 3; j++) {
                dp[0][j] = (first == j) ? rgb[0][j] : INF;
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (first != j) { //마지막 집은 첫 집이랑 색이 달라야 함
                    answer = Math.min(answer, dp[n - 1][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
