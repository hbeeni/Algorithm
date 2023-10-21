package algorithmcodingtest.combination.binomial_theorem;

import java.util.Scanner;

public class B11050_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[i][0] = 1;
            a[i][1] = i;
            a[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1]; //조합 기본 점화식
            }
        }

        System.out.println(a[n][k]);
    }
}
