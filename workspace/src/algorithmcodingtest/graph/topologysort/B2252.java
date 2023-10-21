//오답

package algorithmcodingtest.graph.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] d = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            d[y]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                d[i] = -1;
                sb.append(i).append(" ");

                for (int j = 0; j < graph[i].size(); j++) {
                    d[(graph[i].get(j))]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
