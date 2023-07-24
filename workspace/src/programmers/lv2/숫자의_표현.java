//https://velog.io/@qwe3213/%EC%88%AB%EC%9E%90%EC%9D%98-%ED%91%9C%ED%98%84-Java

package programmers.lv2;

public class 숫자의_표현 {
    public static int solution(int n) {
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int num = i;

            for (int j = i + 1; j <= n; j++) {
                num += j;

                if (num == n) {
                    answer++;
                    break;
                } else if (num > n) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
