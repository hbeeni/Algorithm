class Solution {
    public int solution(int n) {
        int answer = 1;
        int start = 1, end = 2, sum = 3;

        if (n <= 2) {
            return 1;
        }
        
        while (end <= n / 2 + 1) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                answer++;
                sum -= start;
                start++;
                end++;
                sum += end;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3));
    }
}