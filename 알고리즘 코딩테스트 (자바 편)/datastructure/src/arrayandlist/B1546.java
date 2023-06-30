package arrayandlist;

import java.util.Scanner;

public class B1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int score, max = 0;
        long sum = 0L;

        for (int i = 0; i < n; i++) {
            score = sc.nextInt();
            sum += score;
            max = (max > score) ? max : score;
        }

        System.out.println((float) sum / max * 100 / n);
    }
}
