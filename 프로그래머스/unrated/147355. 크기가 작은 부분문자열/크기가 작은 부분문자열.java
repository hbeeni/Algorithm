class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long vs = Long.parseLong(p);
        int start = 0, end = p.length();

        while (end <= t.length()) {
            long num = Long.parseLong(t.substring(start, end));
            if (num <= vs) {
                answer++;
            }
            start++;
            end++;
        }
        
        return answer;
    }
}