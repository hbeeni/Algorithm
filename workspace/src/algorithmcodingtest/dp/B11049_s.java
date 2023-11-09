package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11049_s {

    static int n;
    static Matrix[] m;
    static int[][] dp; //i ~ j 번째 행렬까지 최소 연산 횟수를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new Matrix[n + 1];
        dp = new int[n + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            m[i] = new Matrix(x, y);
        }

        System.out.println(execute(1, n));
    }

    //top-down
    private static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (dp[s][e] != -1) { //계산했던 부분이면 다시 계산하지 않음 (Memoization)
            return dp[s][e];
        }
        if (s == e) { //행렬 1개
            return 0;
        }
        if (s + 1 == e) { //행렬 2개
            return m[s].x * m[s].y * m[e].y;
        }
        for (int i = s; i < e; i++) { //행렬 3개 이상 -> 점화식 처리
            //execute(s, i) + execute(i + 1, e) + 앞뒤 구간의 행렬을 합치기 위한 연산 횟수
            result = Math.min(result, execute(s, i) + execute(i + 1, e) + m[s].x * m[i].y * m[e].y);
        }
        return dp[s][e] = result;
    }

    static class Matrix {
        private int x;
        private int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
