//못 품

package algorithmcodingtest.number_theory.eulerphi;

import java.util.Arrays;
import java.util.Scanner;

public class B11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        //n을 소인수분해 -> 소인수에 연산 수행
        //소수 구하기: n의 제곱근까지
        int max = (int) Math.sqrt(n);
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            for (int j = i * i; j <= max; j += i) {
                prime[j] = false;
            }
        }

        long answer = n;
        //소수만 비교해서 연산 수행 n -= n / prime
        for (int i = 2; i <= max; i++) {
            if (prime[i] && n % i == 0) {
                answer -= answer / i;
            }
        }

        System.out.println(answer);
    }
}
