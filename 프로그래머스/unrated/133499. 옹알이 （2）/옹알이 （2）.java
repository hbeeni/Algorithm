import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] word = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            int index = 0;
            int prev = -1;

            while (index < b.length()) {
                boolean find = false;

                for (int i = 0; i < 4; i++) {
                    if (i == prev) {
                        continue;
                    }

                    if (index + word[i].length() <= b.length()) {
                        String tmp = b.substring(index, index + word[i].length());

                        if (tmp.equals(word[i])) {
                            find = true;
                            prev = i;
                            index += word[i].length();
                            break;
                        }
                    }
                }

                if (!find) {
                    break;
                }
            }

            if (index == b.length()) {
                answer++;
            }
        }

        return answer;
    }
}