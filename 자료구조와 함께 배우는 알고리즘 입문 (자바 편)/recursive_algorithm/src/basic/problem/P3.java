// 배열의 모든 요소의 최대 공약수를 구합니다

package basic.problem;

import java.util.Arrays;

public class P3 {

    static int gcdArray(int[] a) {
        if (a.length == 1) {
            return a[0];
        }

        int x = gcd(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            x = gcd(x, a[i]);
        }

        return x;
    }

    //책
    static int gcdArray(int[] a, int start, int no) {
        if (no == 1) {
            return a[start];
        } else if (no == 2) {
            return gcd(a[start], a[start + 1]);
        } else {
            return gcd(a[start], gcdArray(a, start + 1, no - 1));
        }
    }

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        int[] a = {32, 8, 20, 22};
        System.out.println(Arrays.toString(a));
        System.out.println("최대공약수: " + gcdArray(a));
        System.out.println("최대공약수: " + gcdArray(a, 0, a.length));
    }
}
