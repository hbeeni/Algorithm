import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] a = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            a[i][0] = 1;
            if (k != 0) {
                a[i][1] = i;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
        }

        System.out.println(a[n][k]);
    }
}
