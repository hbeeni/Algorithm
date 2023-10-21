package algorithmcodingtest.datastructure.prefixsum;

import java.util.Scanner;

public class B10986_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] s = new long[n]; //합 배열
        long[] c = new long[m]; //같은 나머지 인덱스 카운트
        long answer = 0;

        s[0] = sc.nextInt();
        for (int i = 1; i < n; i++) { //합 배열 만들기
            s[i] = s[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < n; i++) { //합 배열의 모든 값에 % 연산 수행
            int remainder = (int) (s[i] % m);
            if (remainder == 0) {
                answer++;
            }
            c[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (c[i] > 1) {
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
                answer += c[i] * (c[i] - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
