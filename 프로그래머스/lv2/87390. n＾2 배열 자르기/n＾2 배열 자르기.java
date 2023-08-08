class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int x = (int) (left / n);
        int y = (int) (left % n);

        for (int i = 0; i < answer.length; i++) {
            if (x >= y) {
                answer[i] = x + 1;
            } else {
                answer[i] = y + 1;
            }
            y++;
            if (y == n) {
                y = 0;
                x++;
            }
        }

        return answer;
    }
}