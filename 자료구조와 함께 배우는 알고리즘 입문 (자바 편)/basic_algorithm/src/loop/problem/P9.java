// 정수 b에서 정수 a을 뺀 값을 구합니다(b > a가 되도록 입력받음)

package loop.problem;

import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a값: ");
        int a = sc.nextInt();

        int b;
        while (true) {
            System.out.print("b값: ");
            b = sc.nextInt();

            if (b > a) {
                break;
            }

            System.out.println("a보다 큰 값을 입력하세요!");
        }

        System.out.println("b - a는 " + (b - a) + "입니다.");
    }
}
