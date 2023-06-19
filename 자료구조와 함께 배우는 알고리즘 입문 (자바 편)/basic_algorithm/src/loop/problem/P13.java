// 정사각형을 출력

package loop.problem;

import java.util.Scanner;

public class P13 {

    static void squareV1(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void squareV2(int length) {
        String stars = "";
        for (int i = 0; i < length; i++) {
            stars += "*";
        }

        for (int i = 0; i < length; i++) {
            System.out.println(stars);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length;

        System.out.println("정사각형을 출력합니다.");
        do {
            System.out.print("변의 길이: ");
            length = sc.nextInt();
        } while (length <= 0);

        squareV1(length);
    }
}
