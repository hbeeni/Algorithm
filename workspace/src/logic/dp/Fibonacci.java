package logic.dp;

/**
 * 단순 재귀
 * - 중복되는 호출 발생
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
