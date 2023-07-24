package programmers.lv2;

import java.util.Deque;
import java.util.LinkedList;

public class JadenCase_문자열_만들기 {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Deque<String> q = new LinkedList<>();
        q.offer(String.valueOf(s.charAt(0)).toUpperCase());

        for (int i = 1; i < s.length(); i++) {
            String tmp = String.valueOf(s.charAt(i));

            if (q.peekLast().equals(" ")) {
                q.offer(tmp.toUpperCase());
            } else {
                q.offer(tmp.toLowerCase());
            }
        }

        q.forEach(answer::append);
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }
}
