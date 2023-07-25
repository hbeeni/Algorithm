import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int x = yellow, y = 1;

        for (;x >= 0 ; x--) {
            if (yellow % x != 0) {
                continue;
            }

            y = yellow / x;
            if ((x + 2) * 2 + y * 2 == brown) {
                break;
            }
        }

        return new int[]{x + 2, y + 2};
    }
}