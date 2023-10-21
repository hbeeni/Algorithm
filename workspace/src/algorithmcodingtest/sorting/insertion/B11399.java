package algorithmcodingtest.sorting.insertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int current = a[i];
            int idx = i;

            for (int j = i - 1; j >= 0; j--) {
                if (current < a[j]) {
                    idx = j;
                }
            }

            for (int j = i - 1; j >= idx; j--) {
                a[j + 1] = a[j];
            }
            a[idx] = current;
        }

        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
            result += a[i];
        }
        System.out.println(result);
    }
}
