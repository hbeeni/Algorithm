import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (a1, a2) -> {
            if (a1[1] == a2[1]) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(a[i][0]).append(" ").append(a[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}