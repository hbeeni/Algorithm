//https://velog.io/@jh5253/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AA%A8%EC%9D%8C%EC%82%AC%EC%A0%84-Java%EC%9E%90%EB%B0%94

package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    static List<String> list = new ArrayList<>();
    static String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("", 0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i;
            }
        }

        return -1;
    }

    private void dfs(String str, int len) {
        list.add(str);

        if (len == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1);
        }
    }

    public static void main(String[] args) {
        모음사전 m = new 모음사전();
        System.out.println(m.solution("AAAAE")); //6
        System.out.println(m.solution("AAAE")); //10
        System.out.println(m.solution("I")); //1563
        System.out.println(m.solution("EIO")); //1189
    }
}
