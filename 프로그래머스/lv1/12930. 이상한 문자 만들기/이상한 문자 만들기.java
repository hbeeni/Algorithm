class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(' ');
                index = 0;
            } else {
                if (index % 2 == 0) {
                    sb.append(String.valueOf(ch).toUpperCase());
                } else {
                    sb.append(String.valueOf(ch).toLowerCase());
                }
                
                index++;
            }
        }
        
        return sb.toString();
    }
}