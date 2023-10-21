package algorithmcodingtest.graph.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1]; //진입차수
        int[] selfBuild = new int[n + 1]; //자기 자신을 짓는데 걸리는 시간

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    break;
                }
                graph.get(x).add(i);
                inDegree[i]++; //진입차수 배열 초기화
            }
        }

        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                inDegree[next]--;
                //시간 업데이트
                //Math.max(현재 건물에 저장된 최대 시간, 이전 건물에 저장된 최대 시간 + 현재 건물의 생산 시간)
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
