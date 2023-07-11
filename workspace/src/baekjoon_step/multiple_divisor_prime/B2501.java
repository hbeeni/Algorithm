//https://comain.tistory.com/80

package baekjoon_step.multiple_divisor_prime;

import java.util.Scanner;

public class B2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        int num = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count == k) {
                num = i;
                break;
            }
        }

        System.out.println(num);
    }
}