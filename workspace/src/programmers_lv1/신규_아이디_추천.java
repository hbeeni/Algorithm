//https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C-java-2021-KAKAO-BLIND-RECRUITMENT

package programmers_lv1;

public class 신규_아이디_추천 {

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase(); //1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); //2단계
        answer = answer.replaceAll("[.]{2,}", "."); //3단계
        answer = answer.replaceAll("^[.]|[.]$", ""); //4단계

        if (answer.equals("")) { //5단계
            answer = "a";
        }

        if (answer.length() >= 16) { //6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        if (answer.length() <= 2) { //7단계
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
