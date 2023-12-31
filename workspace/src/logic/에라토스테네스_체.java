package logic;

import java.util.Arrays;

/**
 * 소수 구하기: 에라토스테네스의 체 알고리즘
 */
public class 에라토스테네스_체 {
    public static void main(String[] args) {
        int num = 1000000;

        //소수가 true
        boolean[] prime = new boolean[num + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(prime.length - 1); i++) {
            for (int j = i * i; j <= prime.length - 1; j += i) {
                prime[j] = false;
            }
        }

//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            for (int j = i * i; j <= num; j += i) {
//                prime[j] = false;
//            }
//        }

        //소수가 false
        boolean[] composite = new boolean[num + 1];
        composite[0] = composite[1] = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (composite[i]) continue;

            for (int j = i * i; j <= num; j += i) {
                composite[j] = true;
            }
        }
    }
}
