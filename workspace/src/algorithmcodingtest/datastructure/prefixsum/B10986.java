//long count로 하니까 맞음

package algorithmcodingtest.datastructure.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] p = new long[n + 1];
        int[] c = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + Integer.parseInt(st.nextToken());
            c[(int) (p[i] % m)]++;
        }

        long count = c[0];

        for (int i = 0; i < m; i++) {
            int tmp = c[i] - 1 < 0 ? 0 : c[i] - 1;

            for (int j = tmp; j > 0; j--) {
                count += j;
            }
        }

        System.out.println(count);
    }
}
