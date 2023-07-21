import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[123456 * 2 + 1];
        Arrays.fill(prime, true);

        //에라스토테네스 체 알고리즘
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(prime.length + 1); i++) {
            for (int j = i * i; j < prime.length + 1; j += i) {
                prime[j] = false;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (prime[i]) {
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
    }
}