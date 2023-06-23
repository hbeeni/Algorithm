//재귀 함수를 메모화(memoization, 탑다운)로 구현

package analysis.problem;

public class RecurMemoCount {

    static String[] memo;
    static int count;

    static void recur(int n) {
        count++;

        if (memo[n + 1] != null) {
            System.out.print(memo[n + 1]); //메모 출력
        } else {
            if (n > 0) {
                recur(n - 1);
                System.out.print(n);
                recur(n - 2);
                memo[n + 1] = memo[n] + n + memo[n - 1]; //메모화
            } else {
                memo[n + 1] = ""; //메모화: recur(0), recur(-1)은 빈 문자열
            }
        }
    }

    public static void main(String[] args) {
        int x = 10;

        memo = new String[x + 2];
        recur(x);
        System.out.println();
        System.out.println("count = " + count);
    }
}
