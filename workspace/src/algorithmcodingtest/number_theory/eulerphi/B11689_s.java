package algorithmcodingtest.number_theory.eulerphi;

import java.util.Scanner;

public class B11689_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;

        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) { //p가 소인면
                result -= result / p;

                while (n % p == 0) { //2^7 * 11이면 2^7을 없애고 11만 남김
                    n /= p;
                }
            }
        }

        if (n > 1) { //아직 소인수 구성이 남았을 때 = 반복문에서 제곱근까지만 탐색 -> 1개의 소인수 누락된 케이스
            result -= result / n;
        }
        System.out.println(result);
    }
}
