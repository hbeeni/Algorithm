//유클리드 호제법으로 최대공약수 구하기
//나열해서 사각형을 완전히 채울 수 있는 가장 큰 정사각형을 구하면 됨

package basic;

public class EuclidGCD {

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        int x = 22;
        int y = 8;
        System.out.println("최대 공약수는 " + gcd(x, y) + "입니다.");
    }
}
