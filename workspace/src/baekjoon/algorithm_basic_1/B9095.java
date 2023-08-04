//https://fbtmdwhd33.tistory.com/73
//https://lotuslee.tistory.com/43

package baekjoon.algorithm_basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[11];
        int t = Integer.parseInt(br.readLine());

        for (int i = 4; i <= 10; i++) {
            a[i] = a[i - 3] + a[i - 2] + a[i - 1]; //점화식
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(a[n]);
        }
    }
}
