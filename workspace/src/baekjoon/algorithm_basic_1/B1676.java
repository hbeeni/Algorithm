//https://velog.io/@sueee2_2/%EB%B0%B1%EC%A4%80-1676.-%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC-0%EC%9D%98-%EA%B0%9C%EC%88%98java
//https://yeoncoding.tistory.com/551

package baekjoon.algorithm_basic_1;

import java.util.Scanner;

public class B1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        /**
         * n!은 곱의 계산 -> 0의 개수는 결국 10이 몇 번 곱해졌는지 세는 것
         * 10 = 2 * 5
         * 1부터 n까지 돌면서 while문으로 소인수분해를 해 그 안에 2 * 5 쌍이 몇 개 있는지 찾으면 됨
         * 이 때, 2는 5보다 작은 수이므로 연속된 수를 곱하게 되면 모든 값들의 소인수분해들은 2의 개수가 5의 개수보다 많음
         * -> 5의 개수에 따라 10의 개수 결정
         */
        for (int i = 5; i <= n; i += 5) {
            int temp = i;

            while (temp % 5 == 0) {
                answer++;
                temp /= 5;
            }
        }

        System.out.println(answer);
    }
}
