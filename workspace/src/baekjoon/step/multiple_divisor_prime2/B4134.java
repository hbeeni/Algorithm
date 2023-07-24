//https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-4134-%EB%8B%A4%EC%9D%8C-%EC%86%8C%EC%88%98-JAVA

package baekjoon.step.multiple_divisor_prime2;

import java.io.*;
import java.math.BigInteger;

public class B4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            BigInteger num = new BigInteger(br.readLine());

            if (num.isProbablePrime(10)) {
                bw.write(String.valueOf(num));
            } else {
                bw.write(String.valueOf(num.nextProbablePrime()));
            }

            bw.write("\n");
        }

        bw.flush();
    }
}
