//Do it! 코딩 테스트 - 자바 편 210p

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (s, e) -> {
            if (s[1] == e[1]) { //종료 시간이 같을 때
                return s[0] - e[0]; //시작 시간 오름차순
            } else {
                return s[1] - e[1]; //종료시간이 다르면 종료 시간 오름차순
            }
        });

        int count = 0;
        int end = -1;

        for (int i = 0; i < n; i++) {
            if (a[i][0] >= end) { //겹치지 않는 다음 회의가 나온 경우
                end = a[i][1]; //종료 시간 업데이트
                count++;
            }
        }

        System.out.println(count);
    }
}
