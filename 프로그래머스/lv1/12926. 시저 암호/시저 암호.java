class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(' ');
            } else if (ch >= 'a' && ch <= 'z') {
                if (ch + n > 'z') {
                    sb.append((char) ('a' + ch + n - 'z' - 1));
                } else {
                    sb.append((char) (ch + n));
                }
            } else {
                if (ch + n > 'Z') {
                    sb.append((char) ('A' + ch + n - 'Z' - 1));
                } else {
                    sb.append((char) (ch + n));
                }
            }
        }
        
        return sb.toString();
    }
}