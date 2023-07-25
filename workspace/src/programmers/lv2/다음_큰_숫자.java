package programmers.lv2;

public class 다음_큰_숫자 {
    public static int solution(int n) {
        int nowCount = Integer.bitCount(n);

        while (true) {
            n++;
            int nextCount = Integer.bitCount(n);

            if (nowCount == nextCount) {
                break;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(solution(78)); //83
        System.out.println(solution(15)); //23
    }
}
