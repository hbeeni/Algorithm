/**
 * https://hellodoor.tistory.com/114
 * 에라토스테네스의 체
 */

package baekjoon.step.multiple_divisor_prime;

import java.util.Arrays;
import java.util.Scanner;

public class B2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        /**
         * 에라스토테네스 체 알고리즘
         */
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < Math.sqrt(n + 1); i++) {
            //i의 제곱수부터 검사하므로 i는 전체 범위의 제곱근까지 검사
            for (int j = i * i; j < n + 1; j += i) {
                prime[j] = false;
            }
        }

        int min = 0, sum = 0;
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                if (min == 0) {
                    min = i;
                }

                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
