class Solution {
    public long[] solution(int x, int n) {
        long[] a = new long[n];
        a[0] = x;
        
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + x;
        }
        
        return a;
    }
}