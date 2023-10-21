//틀림 - 문제 분석 잘못한듯

package algorithmcodingtest.graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1717 {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union(x, y);
            } else {
                if (find(x) == find(y)) {
                    sb.append("yes");
                } else {
                    sb.append("no");
                }
                sb.append("\n");
                System.out.println(Arrays.toString(a));
            }
        }

        System.out.println(sb);
    }

    private static void union(int x, int y) {
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        a[y] = a[x] == x ? x : a[x];
    }

    private static int find(int x) {
        if (a[x] != x) {
            a[x] = find(a[x]);
        }

        return a[x];
    }
}
