package algorithmcodingtest.tree.segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = 1;
        while (Math.pow(2, k) < n) {
            k++;
        }

        int size = (int) Math.pow(2, k + 1);
        int start = (int) Math.pow(2, k);
        int[] tree = new int[size];
        for (int i = 0; i < n; i++) {
            tree[start + i] = Integer.parseInt(br.readLine());
        }
        for (int i = start + n; i < size; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        for (int i = start - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) + start - 1;
            int e = Integer.parseInt(st.nextToken()) + start - 1;
            int min = Integer.MAX_VALUE;

            while (s <= e) {
                if (s % 2 == 1) {
                    min = Math.min(tree[s], min);
                }
                if (e % 2 == 0) {
                    min = Math.min(tree[e], min);
                }
                s = (s + 1) / 2;
                e = (e - 1) / 2;
            }

            System.out.println(min);
        }
    }
}
