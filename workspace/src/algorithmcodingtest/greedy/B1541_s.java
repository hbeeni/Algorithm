//Do it! 코딩 테스트 - 자바 편 213p

package algorithmcodingtest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String example = br.readLine();
        String[] str = example.split("-");

        int answer = 0;
        for (int i = 0; i < str.length; i++) {
            int temp = sum(str[i]);

            if (i == 0) {
                answer += temp; //가장 앞에 있는 값만 더함
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }

    //나뉜 그룹의 더하기 연산 수행
    private static int sum(String a) {
        int sum = 0;
        String[] temp = a.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
