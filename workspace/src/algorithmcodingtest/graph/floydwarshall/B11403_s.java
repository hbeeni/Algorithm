package algorithmcodingtest.graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드-워셜
 */
public class B11403_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] distance = new int[n][n];

        //인접행렬 초기화
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 변형된 플로이드-워셜 알고리즘
         * - s와 e가 모든 중간 경로(k) 중 1개라도 연결돼 있다면 s와 e는 연결 노드
         */
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    if (distance[s][k] == 1 && distance[k][e] == 1) {
                        distance[s][e] = 1;
                    }
                }
            }
        }

        for (int[] ints : distance) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
