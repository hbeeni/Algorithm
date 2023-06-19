// 가우스 공식을 사용하여 1, 2, ..., n의 총합을 구합니다

package loop.problem;

import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum;

        if (n % 2 == 0) {
            sum = (1 + n) * (n / 2);
        } else {
            sum = (1 + (n - 1)) * (n / 2);
            sum += n;
        }

        //책
        sum = (1 + n) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0);

        System.out.println("sum = " + sum);
    }
}
