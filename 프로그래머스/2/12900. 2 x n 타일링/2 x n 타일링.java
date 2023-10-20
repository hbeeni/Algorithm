class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        int[] cases = new int[n + 1];
        cases[1] = 1;
        cases[2] = 2;
        for (int i = 3; i <= n; i++) {
            cases[i] = (cases[i - 1] + cases[i - 2]) % MOD;
        }
        return cases[n];
    }
}