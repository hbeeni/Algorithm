import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
