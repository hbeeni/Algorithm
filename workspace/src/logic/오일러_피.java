package logic;

import java.util.Arrays;

/**
 * P[N] = 1부터 N까지 범위에서 N과 서로소인 자연수의 개수
 * 1. 구하고자 하는 오일러 피의 범위만큼 배열 초기화
 * 2. 2부터 시작해 현재 배열의 값과 인덱스가 같으면(= 소수면)
 *    현재 선택된 숫자(k)의 배수에 해당하는 수를 배열에 끝까지 탐색하며 P[i] = P[i] - P[i] / K 연산 수행
 * 3. 배열의 끝까지 2를 반복
 */
public class 오일러_피 {
    public static void main(String[] args) {
        int n = 15;
        int[] a = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            a[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (a[i] != i) {
                continue;
            }

            for (int j = i; j <= n; j += i) {
                a[j] -= a[j] / i;
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
