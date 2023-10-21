//오답, 테케 통과

package algorithmcodingtest.graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
            dp[s][e] = dp[e][s] = 1;
        }

        int maxValue = 101;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == j) {
                    continue;
                }
                dp[i][j] = dp[i][j] == 0 ? maxValue : dp[i][j];
            }
        }

        for (int s = 1; s <= 5; s++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            queue.add(s);
            visited[s] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int e : list.get(now)) {
                    if (!visited[e]) {
                        dp[s][e] = Math.min(dp[s][e], dp[s][now] + 1);
                        queue.add(e);
                        visited[e] = true;
                    }
                }
            }
        }

        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 5; i++) {
            int sum = 0;

            for (int j = 1; j <= 5; j++) {
                sum += dp[i][j];
            }

            if (min > sum) {
                min = sum;
                index = i;
            }
        }

        System.out.println(index);
    }
}
