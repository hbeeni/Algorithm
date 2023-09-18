//https://velog.io/@newtownboy/JAVA2133%EB%B2%88-%ED%83%80%EC%9D%BC-%EC%B1%84%EC%9A%B0%EA%B8%B0
//잘 모르겠음

package baekjoon.algorithm_basic_1.dp1.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        //n이 홀수일 경우, 타일 채우기 불가능 -> 0 출력
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp[0] = 1; //타일이 없을 경우 2x1, 1x2 타일로 채울 수 있는 경우의 수는 아무것도 채우지 않는 경우
        dp[1] = 0; //3x1 타일을 채울 수 있는 경우의 수
        dp[2] = 3; //3x2 타일을 채울 수 있는 경우의 수

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }

        System.out.println(dp[n]);
    }
}
