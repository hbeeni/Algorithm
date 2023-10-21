//시간 초과

package algorithmcodingtest.number_theory.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int n = (int) Math.floor(Math.sqrt(max));
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        int count = (int) (max - min + 1);
        for (long i = min; i <= max; i++) {
            for (int j = 0; j < prime.length; j++) {
                if (prime[j] && i % (j * j) == 0) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
