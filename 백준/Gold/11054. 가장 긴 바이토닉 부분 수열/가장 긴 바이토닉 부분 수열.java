import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] increase = new int[n];
        int[] decrease = new int[n];
        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    increase[i] = Math.max(increase[j] + 1, increase[i]);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    decrease[i] = Math.max(decrease[j] + 1, decrease[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, increase[i] + decrease[i]);
        }
        System.out.println(max - 1);
    }
}