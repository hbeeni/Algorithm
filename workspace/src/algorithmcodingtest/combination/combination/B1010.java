package algorithmcodingtest.combination.combination;

import java.util.Scanner;

public class B1010 {
    public static void main(String[] args) {
        int[][] bridges = new int[30][30];
        for (int i = 1; i < 30; i++) {
            bridges[1][i] = i;
            bridges[i][i] = 1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = i; j < 30; j++) {
                bridges[i][j] = bridges[i][j - 1] + bridges[i - 1][j - 1];
            }
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(bridges[n][m]);
        }
    }
}
