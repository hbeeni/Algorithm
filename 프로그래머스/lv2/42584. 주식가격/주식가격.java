class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;
            for (; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = j - i + (j == prices.length ? -1 : 0);
        }
        
        return answer;
    }
}