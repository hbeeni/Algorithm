//https://pangtrue.tistory.com/317

package baekjoon.algorithm_basic_1.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 7을 1, 2, 3의 합으로 나타내는 경우의 수
 * 1) 7을 만드는 수식 중 마지막이 1로 끝나는 것의 수
 * 6을 만드는 수식 중 마지막이 2로 끝나는 것 + 1
 * 6을 만드는 수식 중 마지막이 3로 끝나는 것 + 1
 * -> DP[7][1] = DP[6][2] + DP[6][3]
 *
 * 2) 7을 만드는 수식 중 마지막이 2로 끝나는 것의 수
 * 5를 만드는 수식 중 마지막이 1로 끝나는 것 + 2
 * 5를 만드는 수식 중 마지막이 3로 끝나는 것 + 2
 * -> DP[7][2] = DP[5][1] + DP[5][3]
 *
 * 3) 7을 만드는 수식 중 마지막이 3로 끝나는 것의 수
 * 4를 만드는 수식 중 마지막이 1로 끝나는 것 + 3
 * 4를 만드는 수식 중 마지막이 2로 끝나는 것 + 3
 * -> DP[7][3] = DP[4][1] + DP[4][2]
 *
 * 점화식)
 * DP[N][1] = DP[N - 1][2] + DP[N - 1][3]
 * DP[N][2] = DP[N - 2][1] + DP[N - 2][3]
 * DP[N][3] = DP[N - 3][1] + DP[N - 3][2]
 */
public class B15990 {
    public static void main(String[] args) throws IOException {
        int mod = 1_000_000_009;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] cache = new long[100_001][4];
        cache[1][1] = 1;
        cache[2][2] = 1;
        cache[3][1] = 1;
        cache[3][2] = 1;
        cache[3][3] = 1;

        for (int i = 4; i < 100_000; i++) {
            cache[i][1] = (cache[i - 1][2] + cache[i - 1][3]) % mod;
            cache[i][2] = (cache[i - 2][1] + cache[i - 2][3]) % mod;
            cache[i][3] = (cache[i - 3][1] + cache[i - 3][2]) % mod;
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            long result = (cache[num][1] + cache[num][2] + cache[num][3]) % mod;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
