//https://hy-ung.tistory.com/60

package programmers.lv2;

public class 멀리_뛰기 {
    public static long solution(int n) {
        long[] a = new long[n + 2];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;

        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 1234567;
        }

        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4)); //5
        System.out.println(solution(3)); //3
    }
}
