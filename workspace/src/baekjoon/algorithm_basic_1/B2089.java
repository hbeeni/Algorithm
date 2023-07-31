//https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-2089%EB%B2%88-2%EC%A7%84%EC%88%98-Java-%EC%9E%90%EB%B0%94
//https://programming-beard.tistory.com/107

package baekjoon.algorithm_basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        /*
        -13 = (-2 * 7) + 1
        7 = (-2 * -3) + 1
        - 3 = (-2 * 2) + 1
        2 = (-2 * -1) + 0
        - 1 = (-2 * 1) + 1
        1
        */
        if (n == 0) {
            System.out.println(0);
        } else {
            while (n != 1) {
                sb.append(Math.abs(n % -2));
                n = (int) Math.ceil((double) n / (-2));
            }

            sb.append(n);
            System.out.println(sb.reverse());
        }
    }
}
