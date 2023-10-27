package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13398_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        //오른쪽 방향으로 index를 포함한 최대 연속 합 구하기
        int[] l = new int[n];
        int result = l[0] = a[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(a[i], a[i] + l[i - 1]);
            result = Math.max(result, l[i]); //1개도 제거하기 않았을 때를 기본 최댓값으로 설정
        }

        //왼쪽 방향으로 index를 포함한 최대 연속 합 구하기
        int[] r = new int[n];
        r[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(a[i], a[i] + r[i + 1]);
        }

        //l[i - 1] + r[i + 1] 2개의 구간 합 배열을 거하면 i번째 값을 제거한 효과를 얻음
        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, l[i - 1] + r[i + 1]);
        }
        System.out.println(result);
    }
}
