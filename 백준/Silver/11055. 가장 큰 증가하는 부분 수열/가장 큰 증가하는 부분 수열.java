import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = a[i];
        }

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i] && dp[j] >= dp[max]) {
                    max = j;
                }
            }
            dp[i] += dp[max];
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }
}