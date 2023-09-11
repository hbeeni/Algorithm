import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> routes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            routes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            routes.get(start).add(new Node(end, value));
        }

        long[] shortest = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }

        //정답 업데이트
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 0; i < n - 1; i++) {
            Integer[] tmp = set.toArray(Integer[]::new);
            for (int start : tmp) {
                for (Node node : routes.get(start)) {
                    set.add(node.end);
                    shortest[node.end] = Math.min(shortest[start] + node.value, shortest[node.end]);
                }
            }
        }

        //음수 사이클 유무 확인
        boolean minusCycle = false;
        Integer[] tmp = set.toArray(Integer[]::new);
        cycle: for (int start : tmp) {
            for (Node node : routes.get(start)) {
                if (shortest[start] + node.value < shortest[node.end]) {
                    minusCycle = true;
                    break cycle;
                }
            }
        }

        if (minusCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (shortest[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(shortest[i]);
                }
            }
        }
    }

    static class Node {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
}
