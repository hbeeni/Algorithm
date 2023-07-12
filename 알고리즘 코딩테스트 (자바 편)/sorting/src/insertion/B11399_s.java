package insertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11399_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        //삽입 정렬
        for (int i = 1; i < n; i++) {
            int insertPoint = i;
            int insertValue = a[i];

            for (int j = i - 1; j >= 0 ; j--) {
                if (a[j] < insertValue) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0) {
                    insertPoint = 0;
                }
            }

            //삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
            for (int j = i; j > insertPoint ; j--) {
                a[j] = a[j - 1];
            }
            //삽입 위치에 현재 데이터 삽입
            a[insertPoint] = insertValue;
        }

        int[] s = new int[n]; //합배열
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + a[i];
        }

        int sum = 0;
        for (int num : s) {
            sum += num;
        }

        System.out.println(sum);
    }
}
