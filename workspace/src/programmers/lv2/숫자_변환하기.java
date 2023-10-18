//https://ksb-dev.tistory.com/267

package programmers.lv2;

public class 숫자_변환하기 {
    public static int solution(int x, int y, int n) {
        final int MAX = Integer.MAX_VALUE;
        int[] dp = new int[y + 1];

        for (int i = x + 1; i <= y; i++) {
            int case1 = MAX;
            int case2 = MAX;
            int case3 = MAX;

            if (i % 2 == 0 && i / 2 >= x) {
                case1 = dp[i / 2];
            }
            if (i % 3 == 0 && i / 3 >= x) {
                case2 = dp[i / 3];
            }
            if (i - n >= x) {
                case3 = dp[i - n];
            }

            int min = Math.min(Math.min(case1, case2), case3);
            dp[i] = min == MAX ? MAX : min + 1;
        }

        return dp[y] == MAX ? -1 : dp[y];
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5)); //2
        System.out.println(solution(10, 40, 30)); //1
        System.out.println(solution(2, 5, 4)); //-1
    }
}
