//https://st-lab.tistory.com/98

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nStr = sc.next();

        int length = nStr.length();
        int n = Integer.parseInt(nStr);
        int result = 0;

        /**
         * 생성자: k, 각 자릿수: k1, k2, ...
         * n = k + k1 + k2 + ...
         * -> k = n - (k1 + k2 + ...)
         * -> 모든 자릿수가 9일 때 k 최소
         * => 초기값 = n - n 길이 * 9
         */
        for (int i = n - length * 9; i < n; i++) {
            int num = i, sum = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
