package floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] distance = new int[n + 1][n + 1];
        int maxValue = 10000001;

        /**
         * 인접행렬 초기화
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    distance[i][j] = maxValue; //충분히 큰 수로 저장
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (cost < distance[s][e]) {
                distance[s][e] = cost;
            }
        }

        /**
         * 플로이드-워셜 알고리즘
         * - 3중 for문의 순서가 중요
         * - k -> s -> e
         */
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (distance[s][k] != maxValue && distance[k][e] != maxValue) {
                        distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == maxValue) {
                    sb.append(0);
                } else {
                    sb.append(distance[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
