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

        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1000000];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(prime.length - 1); i++) {
            for (int j = i * i; j <= prime.length - 1; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            int s = 2;
            int e = num - 1;
            int count = 0;

            while (!prime[e]) {
                e--;
            }

            while (s <= e) {
                if (s + e == num) {
                    count++;
                    s++;
                    e--;
                } else if (s + e > num) {
                    e--;
                } else {
                    s++;
                }

                while (s < prime.length && !prime[s]) {
                    s++;
                }
                while (e >= 0 && !prime[e]) {
                    e--;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
    }
}