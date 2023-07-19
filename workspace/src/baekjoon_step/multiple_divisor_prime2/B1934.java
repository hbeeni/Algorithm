//https://velog.io/@wjdtjsah12/%EB%B0%B1%EC%A4%80-1934%EB%B2%88-%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98Java

package baekjoon_step.multiple_divisor_prime2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = getGCD(a, b);

            sb.append(a * b / gcd).append("\n");
        }

        System.out.println(sb);
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}
