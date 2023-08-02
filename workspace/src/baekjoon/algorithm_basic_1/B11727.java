//https://girawhale.tistory.com/34

package baekjoon.algorithm_basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 2];
        a[1] = 1;
        a[2] = 3;

        //a[n] = a[n - 1] + 2 * a[n - 2]
        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 1] + 2 * a[i - 2]) % 10007;
        }

        System.out.println(a[n]);
    }
}
