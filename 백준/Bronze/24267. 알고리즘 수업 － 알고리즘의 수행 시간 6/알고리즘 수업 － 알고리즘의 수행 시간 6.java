import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long result = 0;
        for (long i = n - 2, j = 1; i > 0; i--, j++) {
            result += i * j;
        }

        System.out.println(result);
        System.out.println(3);
    }
}