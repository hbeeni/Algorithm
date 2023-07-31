package logic.dp;

/**
 * 상향식
 * - 반복문 사용
 */
public class BottomUp {
    static int[] a;

    public static void main(String[] args) {
        int n = 10;
        a = new int[n + 1];
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}
