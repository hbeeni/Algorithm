import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int count = 0;
        int s = 0;
        int e = n - 1;

        while (s < e) {
            if (a[s] + a[e] == m) {
                count++;
                s++;
                e--;
            } else if (a[s] + a[e] < m) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(count);
    }
}
