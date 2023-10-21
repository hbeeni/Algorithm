package algorithmcodingtest.combination.permutation.complete;

import java.util.Scanner;

/** 완전 순열: n개의 원소의 집합에서 원소들을 재배열할 때 이전과 같은 위치에 배치되는 원소가 1개도 없을 때 */
public class B1947 {
    public static void main(String[] args) {
        final int MOD = 1_000_000_000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*
        cases[n] = n명일 때 선물을 교환할 수 있는 모든 경우의 수
        선물을 교환하는 2가지 방식
        1. B와 A가 서로에게 선물을 줬을 때 (양방향 교환)
            : n명 중 2명이 교환을 완료했으므로 남은 경우의 수는 cases[n - 2]
        2. B는 A가 아닌 다른 사람에게 선물을 줄 때 (단방향 교환)
            : n명 중 B만 받은 선물이 정해진 상태이므로 남은 학생은 n - 1명 -> 경우의 수는 cases[n - 1]
         */
        long[] cases = new long[n + 1];
        if (n >= 2) {
            cases[2] = 1;
        }
        for (int i = 3; i <= n; i++) {
            cases[i] = (cases[i - 1] + cases[i - 2]) * (i - 1) % MOD; //완전 순열 점화식
        }

        System.out.println(cases[n]);
    }
}
