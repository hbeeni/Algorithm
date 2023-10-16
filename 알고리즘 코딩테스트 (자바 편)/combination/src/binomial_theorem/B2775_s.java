package binomial_theorem;

import java.util.Scanner;

public class B2775_s {
    public static void main(String[] args) {
        int[][] apartment = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apartment[i][1] = 1;
            apartment[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(apartment[k][n]);
        }
    }
}
