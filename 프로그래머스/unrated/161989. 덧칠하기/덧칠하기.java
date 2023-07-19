class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = 0;
        
        for (int i = 0; i < section.length; i++) {
            if (section[i] < start) {
                continue;
            }
            
            start = section[i] + m;
            answer++;
            
            if (start > n) {
                break;
            }
        }
        
        return answer;
    }
}