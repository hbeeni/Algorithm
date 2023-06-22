// 팩토리얼 값을 비재귀적으로 구합니다

package basic.problem;

public class P1 {

    static int factorial(int x) {
        for (int i = x - 1; i > 0; i--) {
            x *= i;
        }

        return x;

        /* 책
        int fact = 1;

        while (n > 1)
            fact *= n--;
        return fact;
        */
    }

    public static void main(String[] args) {
        int x = 3;
        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
