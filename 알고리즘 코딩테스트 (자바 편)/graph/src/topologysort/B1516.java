//오답

package topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] time = new int[n + 1];
        int[] answer = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            answer[i] = time[i];
            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    break;
                }
                graph.get(x).add(i);
                d[i]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                for (int j = 0; j < graph.get(i).size(); j++) {
                    int node = graph.get(i).get(j);
                    answer[node] += time[i];
                    d[node]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}
