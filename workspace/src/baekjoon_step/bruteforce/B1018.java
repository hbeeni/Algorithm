//https://st-lab.tistory.com/101

package baekjoon_step.bruteforce;

import java.util.Scanner;

public class B1018 {
    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < m; j++) {
                arr[i][j] = (str.charAt(j) == 'W');
            }
        }

        int nRow = n - 7;
        int mCol = m - 7;

        for (int x = 0; x < nRow; x++) {
            for (int y = 0; y < mCol; y++) {
                find(x, y);
            }
        }

        System.out.println(min);
    }

    static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean tf = arr[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (arr[i][j] != tf) {
                    count++;
                }

                tf = !tf;
            }

            tf = !tf;
        }

        //첫 번째 칸 색 기준과 반대 색 기준을 비교
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
