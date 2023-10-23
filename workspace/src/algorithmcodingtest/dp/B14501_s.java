package algorithmcodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 2]; //오늘부터 퇴사일까지 벌 수 있는 최대 수입
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--) {
            if (i + t[i] > n + 1) { //i번째 상담을 퇴사일까지 끝낼 수 없을 때
                d[i] = d[i + 1];
            } else { //i번째 상담을 퇴사일까지 끝낼 수 있을 때
                d[i] = Math.max(d[i + 1], p[i] + d[i + t[i]]);
            }
        }
        System.out.println(d[1]);
    }
}
