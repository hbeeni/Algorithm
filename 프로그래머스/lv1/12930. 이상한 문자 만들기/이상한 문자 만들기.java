class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] a = s.trim().split(" ");

        for (String str : a) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (i % 2 == 0) {
                    sb.append(String.valueOf(ch).toUpperCase());
                } else {
                    sb.append(String.valueOf(ch).toLowerCase());
                }
            }

            sb.append(" ");
        }

        String words = sb.toString().trim();
        sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                break;
            }
        }
        sb.append(words);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                break;
            }
        }

        return sb.toString();
    }
}