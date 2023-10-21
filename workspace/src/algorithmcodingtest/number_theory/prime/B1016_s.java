//Do it! 코딩 테스트 - 자바 편 230p
//이해 못하겠음

package algorithmcodingtest.number_theory.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1016_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];

        //2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = i * i;
            long start = min / pow;

            if (min % pow != 0) {
                start++; //나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작됨
            }

            //제곱수를 true로 변경
            for (long j = start; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for (boolean pow : check) {
            if (!pow) {
                count++;
            }
        }
        System.out.println(count);
    }
}
