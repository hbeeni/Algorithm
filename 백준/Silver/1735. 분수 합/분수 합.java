//https://steady-coding.tistory.com/254

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //a/b c/d
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int denominator = b * d;
        int numerator = a * d + b * c;

        int gcd = getGCD(denominator, numerator);

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