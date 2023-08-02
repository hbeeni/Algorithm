class Solution {
    public int solution(int num) {
        if (num == 1) {
            return 0;
        }

        long n = num;
        int i = 0;

        for (; i < 500; i++) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }

            if (n == 1) {
                break;
            }
        }
        return i == 500 ? -1 : i + 1;
    }
}