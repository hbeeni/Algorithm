import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    list.get(i).add(j);
                }
            }
        }

        int[][] answer = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();
                ArrayList<Integer> nowList = list.get(now);

                for (int j : nowList) {
                    answer[i][j] = 1;

                    if (!visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
