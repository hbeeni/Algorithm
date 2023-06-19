package loop;

import java.util.Scanner;

public class PrintStars {
    static void printStarsV1(int n, int w) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");

            if (i % w == 0) {
                System.out.println();
            }
        }

        if (n % w != 0) {
            System.out.println();
        }
    }

    static void printStarsV2(int n, int w) {
        for (int i = 0; i < n / w; i++) {
            System.out.println("*".repeat(w));
        }

        if (n % w != 0) {
            System.out.println("*".repeat(n % w));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, w;

        System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");

        do {
            System.out.print("n값: ");
            n = sc.nextInt();
        } while (n <= 0);

        do {
            System.out.print("w값: ");
            w = sc.nextInt();
        } while (w <= 0 || w > n);

        printStarsV2(n, w);
    }
}
