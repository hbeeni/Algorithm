import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        
        prime[0] = prime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }
        
        for (boolean isPrime : prime) {
            if (isPrime) {
                answer++;
            }
        }
        
        return answer;
    }
}