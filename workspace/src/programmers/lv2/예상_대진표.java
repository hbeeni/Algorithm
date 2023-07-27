//https://velog.io/@jp-share/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%98%88%EC%83%81-%EB%8C%80%EC%A7%84%ED%91%9CJava

package programmers.lv2;

public class 예상_대진표 {
    public static int solution(int n, int a, int b) {
        int answer = 0;

        //(1,2) (3,4) (5,6) ... -> + 1 / 2 값이 같으면 같은 그룹
        while(a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7)); //3
    }
}
