// 특수문자 *으로 피라미드를 출력

package loop.problem;

import java.util.Scanner;

public class P15 {

    static void spiraV1(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(n - i));
            System.out.println("*".repeat(2 * i - 1));
        }
    }

    static void spiraV2(int n) {
        for (int i = 1; i <= n; i++) {                  // i 행( i = 1, 2, ... , n )
            for (int j = 1; j <= n - i; j++)            // n - i 개의 ' ' 을 출력
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++)  // (i - 1) * 2 + 1 개의 '*' 을 출력
                System.out.print('*');
            System.out.println();                       // 줄바꿈
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("피라미드를 출력합니다.");

        do {
            System.out.print("단수는 : ");
            n = sc.nextInt();
        } while (n <= 0);

        spiraV1(n);
        spiraV2(n);
    }
}
