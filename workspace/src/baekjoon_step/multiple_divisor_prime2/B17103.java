//https://www.acmicpc.net/problem/17103
//https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-17103%EB%B2%88-%EA%B3%A8%EB%93%9C%EB%B0%94%ED%9D%90-%ED%8C%8C%ED%8B%B0%EC%85%98-Java-%EC%9E%90%EB%B0%94

package baekjoon_step.multiple_divisor_prime2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        //소수 -> false
        boolean[] composite = new boolean[1_000_001];
        composite[0] = composite[1] = true;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (composite[i]) continue;

            for (int j = i * i; j <= 1000000; j += i) {
                composite[j] = true;
            }
        }

        for (int i = 0; i < t; i++) {
            int temp = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int j = 2; j <= temp / 2; j++) {
                if (!composite[j] && !composite[temp - j]) answer++;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
    }
}
