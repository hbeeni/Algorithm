import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());
            list.get(value1).add(value2);
            list.get(value2).add(value1);
        }

        int[] answer = new int[n + 1];
        answer[1] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : list.get(parent)) {
                if (answer[child] == 0) {
                    answer[child] = parent;
                    queue.add(child);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
    
}
