class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int length = number.length() - k;
        int maxIndex = -1;

        while (k > 0) {
            int s = maxIndex + 1;
            int e = s + k;
            maxIndex = findMaxIndex(number, s, e);
            k -= maxIndex - s;
            sb.append(number.charAt(maxIndex) - '0');
            if (sb.length() == length) {
                return sb.toString();
            }
        }
        if (maxIndex + 1 < number.length()) {
            sb.append(number.substring(maxIndex + 1));
        }

        return sb.toString();
    }

    private int findMaxIndex(String number, int s, int e) {
        if (s >= number.length() || e >= number.length()) {
            return number.length() - 1;
        }
        int max = number.charAt(s) - '0';
        int maxIndex = s;
        for (int i = s + 1; i <= e; i++) {
            if (number.charAt(i) - '0' > max) {
                max = number.charAt(i) - '0';
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}