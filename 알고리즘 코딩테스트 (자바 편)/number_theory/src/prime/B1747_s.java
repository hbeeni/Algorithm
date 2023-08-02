//Do it! 코딩 테스트 - 자바 편 226p

package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1747_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //소수 구하기
        int max = 10000000;
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            for (int j = i * i; j <= max; j += i) {
                prime[j] = false;
            }
        }

        int i = n;
        while (true) { //소수 & 팰린드롬 확인
            if (prime[i]) {
                if (isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }
    }

    //팰린드롬수 판별
    private static boolean isPalindrome(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;

        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
}
