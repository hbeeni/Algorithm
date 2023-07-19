package dfs;

import java.util.Scanner;

public class B2023_s {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        //일의 자리 소수는 2, 3, 5, 7
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int number, int jarisu) {
        if (jarisu == n) {
            if (isPrime(number)) {
                System.out.println(number);
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) { //짝수면 더 이상 탐색할 필요가 없음
                continue;
            }
            if (isPrime(number * 10 + i)) { //소수라면 재귀 함수로 자릿수를 늘림
                dfs(number * 10 + i, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
