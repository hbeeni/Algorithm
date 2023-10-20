import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MOD = 1_000_000_000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] cases = new long[n + 1];
        if (n >= 2) {
            cases[2] = 1;
        }
        for (int i = 3; i <= n; i++) {
            cases[i] = (cases[i - 1] + cases[i - 2]) % MOD * (i - 1) % MOD;
        }

        System.out.println(cases[n]);
    }
}
