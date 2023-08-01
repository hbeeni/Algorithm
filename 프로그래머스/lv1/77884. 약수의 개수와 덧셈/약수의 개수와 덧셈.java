class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        int n = 1;
        while (true) {
            if (left <= n * n) {
                break;
            }
            n++;
        }

        for (int i = left; i <= right; i++) {
            if (n * n == i) {
                n++;
                answer -= i;
            } else {
                answer += i;
            }
        }
        
        return answer;
    }
}