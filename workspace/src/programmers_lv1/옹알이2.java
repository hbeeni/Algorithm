//https://velog.io/@subbni/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.1-%EC%98%B9%EC%95%8C%EC%9D%B42-Java

package programmers_lv1;

public class 옹알이2 {
    public static int solution(String[] babbling) {
        int answer = 0;

        for (String b : babbling) {
            if (b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) {
                continue;
            }

            b = b.replace("aya", " ");
            b = b.replace("ye", " ");
            b = b.replace("woo", " ");
            b = b.replace("ma", " ");
            b = b.replace(" ", "");

            if (b.length() == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}
