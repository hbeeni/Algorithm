package logic.dp;

/**
 * 하향식
 * - Memoization
 * - 재귀호출 사용
 */
public class TopDown {
    static int[] a;

    public static void main(String[] args) {
        int n = 10;
        a = new int[n + 1];
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (a[n] != 0) {
            return a[n];
        }
        a[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return a[n];
    }
}
