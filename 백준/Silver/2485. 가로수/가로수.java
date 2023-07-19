import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        long[] minus = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(a);

        for (int i = 1; i < n; i++) {
            minus[i] = a[i] - a[i - 1];
        }

        long gcd = minus[1];
        for (int i = 2; i < n; i++) {
            gcd = getGCD(gcd, minus[i]);

            if (gcd == 1) {
                break;
            }
        }

        long result = 0;
        for (int i = 1; i < n; i++) {
            result += minus[i] / gcd;
        }

        System.out.println(result - minus.length + 1);
    }

    static long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}