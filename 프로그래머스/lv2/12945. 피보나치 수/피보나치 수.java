class Solution {
    public double solution(int n) {
        double answer = 0;
        double n1 = 0, n2 = 1;
        int mod = 1234567;
        int start = 2; //시작값

        while (start <= n) {
            if (n2 > mod) {
                n1 %= mod;
                n2 %= mod;
            }

            answer = n1 + n2;
            n1 = n2;
            n2 = answer;
            start++;
        }

        return (int) (answer % mod);
    }
}