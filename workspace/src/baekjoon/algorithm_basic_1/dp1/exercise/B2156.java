//https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-2156-%ED%8F%AC%EB%8F%84%EC%A3%BC-%EC%8B%9C%EC%8B%9D
//https://minhamina.tistory.com/155

package baekjoon.algorithm_basic_1.dp1.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 3가지 case 중 어떤 것이 가장 많이 마실 수 있는지 판단
         * 1. OOX
         * 2. OXO
         * 3. XOO
         */
        int[] dp = new int[n + 1];
        dp[1] = wines[1]; //dp[1] = 1번째 잔 마시는게 최대
        if (n > 1) {
            dp[2] = wines[1] + wines[2]; //dp[2] = 1, 2번째 잔 다 마시는게 최대
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], //case1
                    Math.max(dp[i - 2] + wines[i], //case2
                            dp[i - 3] + wines[i - 1] + wines[i])); //case3
        }

        System.out.println(dp[n]);
    }
}
