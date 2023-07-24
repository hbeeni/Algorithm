//https://roomconerdeveloper.tistory.com/88

package baekjoon.step.multiple_divisor_prime2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] tree = new long[n];
        long[] distance = new long[n];

        for (int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(tree);

        for (int i = 1; i < n; i++) {
            distance[i] = tree[i] - tree[i - 1];
        }

        long gcd = distance[1];
        for (int i = 2; i < n; i++) {
            gcd = getGCD(gcd, distance[i]);

            if (gcd == 1) {
                break;
            }
        }

        long totalTree = (tree[n - 1] - tree[0]) / gcd + 1;
        System.out.println(totalTree - tree.length);
    }

    static long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
