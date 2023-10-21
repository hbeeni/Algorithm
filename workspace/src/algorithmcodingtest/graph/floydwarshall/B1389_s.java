package algorithmcodingtest.graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1389_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] relation = new int[n + 1][n + 1];

        //인접 행렬 relation 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                relation[i][j] = 10000001;
            }
        }

        //인접 행렬 relation 데이터 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            relation[s][e] = 1;
            relation[e][s] = 1;
        }

        /**
         * 플로이드-워셜 점화식
         * Math.min(relation[s][e], relation[s][k] + relation[k][e])
         */
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    relation[s][e] = Math.min(relation[s][e], relation[s][k] + relation[k][e]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                sum += relation[i][j];
            }

            if (min > sum) {
                index = i;
                min = sum;
            }
        }

        System.out.println(index);
    }
}
