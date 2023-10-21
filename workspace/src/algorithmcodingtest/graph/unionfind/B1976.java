package algorithmcodingtest.graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976 {

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = find(Integer.parseInt(st.nextToken()) - 1);

        for (int i = 1; i < m; i++) {
            if (x != find(Integer.parseInt(st.nextToken()) - 1)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            a[y] = x;
        }
    }

    private static int find(int x) {
        if (a[x] == x) {
            return x;
        }

        return a[x] = find(a[x]);
    }
}
