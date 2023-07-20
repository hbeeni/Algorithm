import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            } else if (n == 1) {
                bw.write(1 + "\n");
                continue;
            }

            int i = n;
            if (n % 2 == 0) {
                i++;
            } else {
                i += 2;
            }

            int count = 0;

            for (; i <= 2 * n; i += 2) {
                boolean isPrime = true;

                for (int j = 3; j <= Math.sqrt(i); j += 2) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
    }
}