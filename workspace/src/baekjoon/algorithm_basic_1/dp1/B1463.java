//https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-1463%EB%B2%88-1%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java-%EC%9E%90%EB%B0%94

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1]; //연산 횟수의 최소값

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + 1;
            if (i % 2 == 0) {
                a[i] = Math.min(a[i], a[i / 2] + 1);
            }
            if (i % 3 == 0) {
                a[i] = Math.min(a[i], a[i / 3] + 1);
            }
        }

        System.out.println(a[n]);
    }
}
