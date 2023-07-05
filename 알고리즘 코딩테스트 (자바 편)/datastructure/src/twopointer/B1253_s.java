package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(a);

        long count = 0;
        for (int i = 0; i < n; i++) {
            long find = a[i];
            int s = 0;
            int e = n - 1;

            while (s < e) {
                if (a[s] + a[e] == find) {
                    //find는 서로 다른 두 수의 합이어야 함
                    if (s != i && e != i) {
                        count++;
                        break;
                    } else if (s == i) {
                        s++;
                    } else if (e == i) {
                        e--;
                    }
                } else if (a[s] + a[e] < find) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
