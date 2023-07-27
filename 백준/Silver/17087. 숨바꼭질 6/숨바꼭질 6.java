import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] distance = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            distance[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
        }

        int gcd = distance[0];
        for (int i = 1; i < n; i++) {
            int a = distance[i];

            while (a != 0) {
                int r = gcd % a;
                gcd = a;
                a = r;
            }
        }

        System.out.println(gcd);
    }
}