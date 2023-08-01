class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        double n = Math.ceil(Math.sqrt(left));

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