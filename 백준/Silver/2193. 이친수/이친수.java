import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] a = new long[n + 1][2];

        a[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i][0] = a[i - 1][1] + a[i - 1][0];
            a[i][1] = a[i - 1][0];
        }

        System.out.println(a[n][0] + a[n][1]);
    }
}