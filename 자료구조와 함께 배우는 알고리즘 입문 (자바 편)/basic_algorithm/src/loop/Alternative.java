package loop;

import java.util.Scanner;

public class Alternative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        do {
            System.out.print("n값: ");
            n = sc.nextInt();
        } while (n <= 0);

        for (int i = 0; i < n / 2; i++) {
            System.out.print("+-");
        }

        if (n % 2 == 1) {
            System.out.print("+");
        }
    }
}
