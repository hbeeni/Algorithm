import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int sum = Integer.MAX_VALUE;
        for (int x = 0; x <= n - 8; x++) {
            for (int y = 0; y <= m - 8; y++) {
                sum = Math.min(sum, getSum(x, y, 0));
                sum = Math.min(sum, getSum(x, y, 1));
            }
        }

        System.out.println(sum);
    }

    static int getSum(int x, int y, int bw) {
        char[] a = null;
        if (bw == 0) {
            a = new char[]{'W', 'B'};
        } else {
            a = new char[]{'B', 'W'};
        }

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i + x][j + y] == a[0]) {
                        sum++;
                    }
                } else {
                    if (board[i + x][j + y] == a[1]) {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}