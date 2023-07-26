import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        int total = 0;
        for (int i : d) {
            total += i;

            if (total <= budget) {
                answer++;
            }
        }
        
        return answer;
    }
}