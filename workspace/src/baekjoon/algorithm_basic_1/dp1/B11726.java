//https://girawhale.tistory.com/33

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 2]; //n + 1 -> n = 1 일 때 a[2]에서 IndexOutOfBoundsException
        a[1] = 1;
        a[2] = 2;

        //a[n] = a[n - 1] + a[n - 2]
        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 10007;
        }

        System.out.println(a[n]);
    }
}
