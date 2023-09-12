package logic;

import java.io.IOException;

/**
 * O(N^3) - N: 정점의 개수
 */
public class 플로이드워셜_최단거리 {
    public static void main(String[] args) throws IOException {
        int n = 5;
        int[][] distance = new int[n + 1][n + 1];

        /**
         * 인접행렬 초기화
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    distance[i][j] = Integer.MAX_VALUE; //충분히 큰 수로 저장
                }
            }
        }

        distance[1][2] = 8;
        distance[1][3] = 3;
        distance[2][4] = -4;
        distance[2][5] = 15;
        distance[3][4] = 13;
        distance[4][5] = 2;
        distance[5][4] = 5;

        /**
         * 플로이드-워셜 알고리즘
         * - 3중 for문의 순서가 중요
         * - k -> s -> e
         */
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (distance[s][k] != Integer.MAX_VALUE && distance[k][e] != Integer.MAX_VALUE) {
                        distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("0 ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
