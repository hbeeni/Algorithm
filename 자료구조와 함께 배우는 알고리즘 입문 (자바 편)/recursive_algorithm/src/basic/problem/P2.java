// 유클리드 호제법에 의해 최대 공약수를 비재귀적으로 구합니다

package basic.problem;

public class P2 {

    static int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }

        return x;
    }

    public static void main(String[] args) {
        int x = 22;
        int y = 8;
        System.out.println("최대 공약수는 " + gcd(x, y) + "입니다.");
    }
}
