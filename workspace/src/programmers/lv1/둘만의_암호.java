package programmers.lv1;

public class 둘만의_암호 {
    public static String solution(String s, String skip, int index) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            for (int j = 0; j < index; j++) {
                ch++;

                if (ch > 'z') {
                    ch = 'a';
                }
                if (skip.contains(ch + "")) {
                    j--;
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }
}
