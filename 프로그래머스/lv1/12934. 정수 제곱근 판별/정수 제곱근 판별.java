class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 == 0.0) {
            return (long) ((sqrt + 1) * (sqrt + 1));
        }
        return -1;
    }
}