package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
        }

        int k = Integer.parseInt(br.readLine());
        if (k == 1) {
            System.out.println(1.0);
        } else {
            double x = 1; //분모
            double y = 0; //분자
            for (int count = k; count > 0; count--) {
                x *= total--;
            }
            for (int i = 0; i < m; i++) {
                if (a[i] >= k) {
                    double mul = 1;
                    for (int count = k; count > 0; count--) {
                        mul *= a[i]--;
                    }
                    y += mul;
                }
            }
            System.out.println(y / x);
        }
    }
}
