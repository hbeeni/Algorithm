package basic;

public class Factorial {

    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int x = 3;
        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
