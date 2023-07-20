//https://www.acmicpc.net/problem/1236

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] guards = new char[n][m];

        for (int i = 0; i < n; i++) {
            guards[i] = br.readLine().toCharArray();
        }

        //1. 각 행/열에 대해 경비원이 있는지 확인
        boolean[] existRow = new boolean[n];
        boolean[] existCol = new boolean[m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (guards[row][col] == 'X') {
                    existRow[row] = true;
                    existCol[col] = true;
                }
            }
        }

        //2. 보호받지 못하는 형/열의 개수 구하기 -> 둘 중 큰 값 출력
        int needRowCount = n;
        int needColCount = m;

        for (int i = 0; i < n; i++) {
            if (existRow[i]) {
                needRowCount--;
            }
        }

        for (int i = 0; i < m; i++) {
            if (existCol[i]) {
                needColCount--;
            }
        }

        System.out.println(Math.max(needRowCount, needColCount));
    }
}
