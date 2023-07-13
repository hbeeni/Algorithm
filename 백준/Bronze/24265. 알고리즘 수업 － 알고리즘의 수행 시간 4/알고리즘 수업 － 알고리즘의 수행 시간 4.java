import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (n % 2 == 1) {
            System.out.println(n * ((n - 1) / 2));
        } else {
            System.out.println(n * ((n - 1) / 2) + n / 2);
        }

        System.out.println(2);
    }
}