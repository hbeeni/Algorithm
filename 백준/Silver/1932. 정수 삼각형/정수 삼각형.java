import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paths = new int[n][];

        for (int i = 0; i < n; i++) {
            paths[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                paths[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            paths[i][0] += paths[i - 1][0];
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    paths[i][j] += paths[i - 1][j - 1];
                } else {
                    paths[i][j] += Math.max(paths[i - 1][j - 1], paths[i - 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(paths[n - 1][i], max);
        }
        
        System.out.println(max);
    }
}