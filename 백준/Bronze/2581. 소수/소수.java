import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int min = 0, sum = 0;

        for (int i = m; i <= n; i++) {
            if (i == 1) {
                continue;
            } 
            if (i != 2 && i % 2 == 0) {
                continue;
            }

            boolean isPrime = true;
            for (int j = 3; j < i; j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                if (min == 0) {
                    min = i;
                }

                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}