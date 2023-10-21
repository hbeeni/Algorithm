package algorithmcodingtest.datastructure.prefixsum;

import java.util.Scanner;

public class B11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            p[i + 1] = p[i] + a[i];
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt();
            System.out.println(p[e] - p[s]);
        }
    }
}
