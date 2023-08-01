//Do it! 코딩 테스트 - 자바 편 223p

package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1456_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int n = 10000000;

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                long temp = i;

                while (i <= (double) max / temp) {
                    if (i >= (double) min / temp) {
                        count++;
                    }
                    temp *= i;
                }
            }
        }

        System.out.println(count);
    }
}
