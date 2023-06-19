// 정수a, b를 포함하여 그 사이의 모든 정수의 총합을 구합니다

package loop.problem;

import java.util.Scanner;

public class P8 {

    static int sumOf(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("a와 b를 포함하여 그 사이에 있는 모든 정수의 총합을 구합니다.");
        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.print("b의 값 : ");
        int b = stdIn.nextInt();

        System.out.println("정수 a, b 사이의 모든 정수의 총합은 " + sumOf(a, b) + "입니다.");
    }
}
