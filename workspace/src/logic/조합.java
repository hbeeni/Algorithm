package logic;

public class 조합 {
    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[n + 1][n + 1];

        /**
         * 조합 점화식
         * a[i][j] = a[i - 1][j] + a[i - 1][j - 1]
         * ex) 5개 중 3개를 선택해는 경우의 수 = 4개 중 2개를 선택하는 경우 + 4개 중 3개를 선택하는 경우
         */
        for (int i = 1; i <= n; i++) {
            a[i][0] = 1;
            a[i][1] = i;
            a[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
        }

        //i 중 j개를 고르는 경우의 수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
