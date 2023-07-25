//https://velog.io/@seongwon97/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98-%EC%88%98-Java

package programmers.lv2;

public class 피보나치_수 {
    public static int solution(int n) {
        int mod = 1234567;

        int[] cache = new int[n + 1];
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % mod;
        }

        return cache[n] % mod;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(8));
        System.out.println(solution(100000));
    }
}
