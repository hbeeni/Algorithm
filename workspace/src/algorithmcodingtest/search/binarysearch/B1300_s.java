//Do it! 코딩 테스트 - 자바 편 194p
//https://st-lab.tistory.com/281

package algorithmcodingtest.search.binarysearch;

import java.util.Scanner;

public class B1300_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        long start = 1, end = k;
        long answer = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long count = 0;

            //중앙값보다 작은 수는 몇 개인지 계산하기
            for (int i = 1; i <= n; i++) {
                count += Math.min(middle / i, n);
            }

            if (count < k) {
                start = middle + 1;
            } else {
                answer = middle; //현재 단계의 중앙값을 answer에 저장
                end = middle - 1;
            }
        }

        System.out.println(answer);
    }
}
