package programmers.lv1;

public class 문자열_나누기 {

    public static int solution(String s) {
        int answer = 1;

        char target = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (count == 0) {
                answer++;
                target = s.charAt(i);
            }

            if (target == s.charAt(i)) {
                count++;
            } else {
                count--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }
}
