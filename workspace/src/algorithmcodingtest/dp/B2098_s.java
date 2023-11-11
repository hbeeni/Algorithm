package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2098_s {
    private static final int INF = 1000000 * 16 + 1;
    private static int n;
    private static int[][] w; //i -> j 로 가는 데 드는 비용
    private static int[][] d; //d[c][v] = 현재 도시가 c, 현재까지 방문한 모든 도시 리스트가 v일 때 앞으로 남은 모든 도시를 경유하는 데 필요한 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                d[i][j] = INF; //모든 비용을 충분히 큰 수로 저장
            }
        }

        System.out.println(tsp(0, 1));
    }

    //모든 경우의 수와 관련된 완전 탐색하고 재귀 구현
    private static int tsp(int c, int v) {
        if (v == (1 << n) - 1) { //모든 도시를 방문할 때
            //시작 도시로 돌아갈 수 있을 때 -> return w[c][시작 도시]
            //시작 도시로 돌아갈 수 없을 때 -> return 무한대
            return w[c][0] == 0 ? INF : w[c][0];
        }
        if (d[c][v] != INF) { //이미 계산한 적이 있을 때 -> 바로 리턴 (memoization)
            return d[c][v];
        }
        for (int i = 0; i < n; i++) {
            if ((v & (1 << i)) == 0 && w[c][i] != 0) { //방문한 적이 없고, 갈 수 있는 도시일 때
                d[c][v] = Math.min(d[c][v], tsp(i, (v | (1 << i))) + w[c][i]);
            }
        }
        return d[c][v];
    }
}
