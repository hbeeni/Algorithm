class Solution {
    public String solution(String new_id) {
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                answer.append((char) (ch + 32));
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_') {
                answer.append(ch);
            } else if (ch == '.') {
                if (answer.length() != 0 &&
                        answer.charAt(answer.length() - 1) != '.') {

                    answer.append(ch);
                }
            }
        }

        if (answer.length() > 0) {
            while (answer.charAt(answer.length() - 1) == '.') {
                answer.deleteCharAt(answer.length() - 1);
            }
        }

        int l = answer.length();
        if (l == 0) {
            return "aaa";
        } else if (l >= 16) {
            int i = 14;
            if (answer.charAt(i) == '.') {
                answer.delete(i--, l);

                while (answer.charAt(i) == '.') {
                    answer.deleteCharAt(i--);
                }
            } else {
                answer.delete(i + 1, l);
            }

            return answer.toString();
        } else if (l <= 2) {
            char ch = answer.charAt(l - 1);
            while (l < 3) {
                answer.append(ch);
                l++;
            }
        }

        return answer.toString();
    }
}