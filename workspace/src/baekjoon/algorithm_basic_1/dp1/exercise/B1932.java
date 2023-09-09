//https://dding9code.tistory.com/10

package baekjoon.algorithm_basic_1.dp1.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paths = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                paths[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //System.out.println(Arrays.deepToString(paths));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                paths[i][j] += Math.max(paths[i - 1][j - 1], paths[i - 1][j]);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(paths[n][i], max);
        }

        System.out.println(max);
    }
}
