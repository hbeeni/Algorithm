package algorithmcodingtest.combination.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1256_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        final int KMAX = 1_000_000_000;
        //n + m개에서 n개를 뽑는 경우의 수 = n + m개에서 m개를 뽑는 경우의 수
        //조합 테이블 초기화
        int[][] arr = new int[n + m + 1][n + m + 1];
        for (int i = 0; i <= n + m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                    if (arr[i][j] > KMAX) {
                        arr[i][j] = KMAX + 1;
                    }
                }
            }
        }

        if (arr[n + m][m] < k) {
            System.out.println(-1);
        } else  {
            while (!(n == 0 && m == 0)) {
                //a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 k보다 크면
                if (arr[n - 1 + m][m] >= k) {
                    System.out.print("a");
                    n--;
                } else { //모든 경우의 수가 k보다 작으면
                    System.out.print("z");
                    k = k - arr[n - 1 + m][m];
                    m--;
                }
            }
        }
    }
}
