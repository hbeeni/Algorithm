package algorithmcodingtest.number_theory.euclidean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1033_s {
    static ArrayList<Node>[] arr;
    static long lcm;
    static boolean[] visited;
    static long[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));
            lcm *= (p * q) / gcd(p, q); //최소 공배수 = 두 수의 곱 / 최대 공약수
        }

        d[0] = lcm;
        dfs(0);
        long mgcd = d[0];
        for (int i = 0; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }

        for (int i = 0; i < n; i++) {
            bw.write(d[i] / mgcd + " ");
        }

        bw.flush();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private static void dfs(int x) {
        visited[x] = true;

        for (Node node : arr[x]) {
            int next = node.b;
            if (!visited[next]) {
                d[next] = d[x] * node.q / node.p; //주어진 비율로 다음 노드값 갱신
                dfs(next);
            }
        }
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
}
