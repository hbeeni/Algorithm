//재귀 함수를 메모화(memoization, 탑다운)로 구현
//ex) recur(1)이 원래는 3회 실행됐지만 메모화를 사용해 1회만 수행

package analysis;

public class RecurMemo {

    static String[] memo;

    static void recur(int n) {
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
        int x = 4;

        memo = new String[x + 2];
        recur(x);
    }
}
