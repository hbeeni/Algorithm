import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int k) {
        String radixString = Integer.toString(n, k);
        Queue<Character> queue = new LinkedList<>();
        int answer = 0;
        
        for (int i = 0; i < radixString.length(); i++) {
            char now = radixString.charAt(i);
            
            if (now == '0') {
                String tmp = "";
                while (!queue.isEmpty()) {
                    tmp += queue.poll();
                }

                if (!tmp.isEmpty()) {
                    BigInteger num = new BigInteger(tmp, 10);
                    if (num.isProbablePrime(10)) {
                        answer++;
                    }
                }
            } else {
                queue.add(now);
            }
        }

        String tmp = "";
        while (!queue.isEmpty()) {
            tmp += queue.poll();
        }

        if (!tmp.isEmpty()) {
            BigInteger num = new BigInteger(tmp, 10);
            if (num.isProbablePrime(10)) {
                answer++;
            }
        }
        
        return answer;
    }
}