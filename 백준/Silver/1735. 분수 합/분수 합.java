import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //a/b c/d
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int gcd = getGCD(b, d);

        int denominator = b * d / gcd; //분모
        int numerator = a * (denominator / b) + c * (denominator / d); //분자

        gcd = getGCD(denominator, numerator);

        System.out.println(numerator / gcd + " " + denominator / gcd);
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}