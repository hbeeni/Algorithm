import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1001];
        prime[2] = true;
        for (int i = 3; i < prime.length; i += 2) {
            prime[i] = true;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!prime[num]) {
                continue;
            }

            for (int j = 3; j < num; j += 2) {
                if (num % j == 0) {
                    prime[num] = false;
                    break;
                }
            }

            if (prime[num]) {
                result++;
            }
        }

        System.out.println(result);
    }
}