package algorithmcodingtest.number_theory.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long left = Long.parseLong(st.nextToken());
        long right = Long.parseLong(st.nextToken());

        int n = (int) Math.sqrt(right);
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        Set<Double> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                int pow = 2;

                while (true) {
                    if (Math.pow(i, pow) > right) {
                        break;
                    }
                    if (Math.pow(i, pow) < left) {
                        pow++;
                        continue;
                    }

                    set.add(Math.pow(i, pow++));
                }
            }
        }

        System.out.println(set.size());
    }
}
