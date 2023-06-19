// 왼쪽 아래가 직각인 이등변삼각형 출력

package loop;

import java.util.Scanner;

public class TriangleLB {
    static void drawTriangleV1(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(i + 1));
        }
    }

    static void drawTriangleV2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("왼쪽 아래가 직각인 이등변삼각형 출력");
        do {
            System.out.print("몇 단 삼각형입니까?: ");
            n = sc.nextInt();
        } while (n <= 0);

        drawTriangleV2(n);
    }
}
