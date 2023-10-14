package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 11438: LCA 2
[입력]
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15

[출력]
2
4
2
1
3
1
 */
public class 제곱근이용_빠르게_최소공통조상찾기 {

    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kMax;
    static int[][] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //노드 수

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        //인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[n + 1];
        visited = new boolean[n + 1];
        int temp = 1;
        kMax = 0;
        //최대 가능 높이(kMax) 구하기
        while (temp <= n) {
            temp <<= 1;
            kMax++;
        }

        parent = new int[kMax + 1][n + 1];
        bfs(); //depth를 bfs를 이용해서 구하기
        for (int i = 1; i <= kMax; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]]; //부모 노드 배열 점화식
            }
        }

        int m = Integer.parseInt(br.readLine()); //질의 수
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = executeLCA(a, b);
            System.out.println(lca);
        }
    }

    private static int executeLCA(int a, int b) {
        //더 깊은 depth가 b가 되도록 변경하기
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        //depth 빠르게 맞추기
        for (int k = kMax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
         //조상 빠르게 찾기
        for (int k = kMax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int lca = a;
        if (a != b) {
            lca = parent[0][lca];
        }
        return lca;
    }

    //bfs
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int level = 1;
        int nowSize = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    parent[0][next] = now;
                    depth[next] = level;
                    visited[next] = true;
                    queue.add(next);
                }
            }

            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }
}
