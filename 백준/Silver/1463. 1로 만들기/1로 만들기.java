import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        a[1] = 0;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                min = Math.min(min, a[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, a[i / 3] + 1);
            }
            min = Math.min(min, a[i - 1] + 1);
            a[i] = min;
        }
        System.out.println(a[n]);
    }
}
