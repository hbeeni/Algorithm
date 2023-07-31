//https://fbtmdwhd33.tistory.com/248

package programmers.lv2;

public class N개의_최소공배수 {
    public static int solution(int[] arr) {
        int gcd = arr[0];
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int n = arr[i];

            while (n != 0) {
                int r = gcd % n;
                gcd = n;
                n = r;
            }

            answer *= arr[i] / gcd;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }
}
