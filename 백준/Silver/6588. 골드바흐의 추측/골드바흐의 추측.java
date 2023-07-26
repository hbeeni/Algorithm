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
        boolean[] prime = new boolean[1000001];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            for (int j = i * i; j <= 1000000; j += i) {
                prime[j] = false;
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                break;
            }

            boolean find = false;
            for (int i = 3; i < num; i += 2) {
                if (prime[i] && prime[num - i]) {
                    find = true;
                    bw.write(num + " = " + i + " + " + (num - i));
                    break;
                }
            }

            if (!find) {
                bw.write("Goldbach's conjecture is wrong.");
            }

            bw.write("\n");
        }

        bw.flush();
    }
}