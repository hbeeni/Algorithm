class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (true) {
            if (b % 2 == 0 && b - a == 1) {
                break;
            }

            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}