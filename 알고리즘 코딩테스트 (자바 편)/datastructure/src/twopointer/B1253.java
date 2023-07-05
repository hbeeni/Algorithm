package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        // -10 0 10
        // -20 -19 -18 -15 -3 0 1 4 5 8 9
        long count = 0;
        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = n - 1;

            while (s < e) {
                if (s == i) {
                    s++;
                    continue;
                }
                if (e == i) {
                    e--;
                    continue;
                }

                if (a[s] + a[e] == a[i]) {
                    count++;
                    break;
                } else if (a[s] + a[e] < a[i]) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        System.out.println(count);
    }
}
