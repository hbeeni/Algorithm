import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int row0LeftExcludedMax = 0;
            int row0Max = stickers[0][0];
            int row1LeftExcludedMax = 0;
            int row1Max = stickers[1][0];

            for (int j = 1; j < n; j++) {
                stickers[0][j] += Math.max(row0LeftExcludedMax, row1Max);
                stickers[1][j] += Math.max(row1LeftExcludedMax, row0Max);

                row0LeftExcludedMax = Math.max(row0LeftExcludedMax, stickers[0][j - 1]);
                row0Max = Math.max(row0Max, stickers[0][j]);
                row1LeftExcludedMax = Math.max(row1LeftExcludedMax, stickers[1][j - 1]);
                row1Max = Math.max(row1Max, stickers[1][j]);
            }
            
            sb.append(Math.max(stickers[0][n - 1], stickers[1][n - 1])).append("\n");
        }

        System.out.println(sb);
    }
}