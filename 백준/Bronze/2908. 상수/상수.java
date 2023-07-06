import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int a = 0;
        int b = 0;
        for (int i = 0; i < 3; i++) {
            a = a * 10 + x % 10;
            b = b * 10 + y % 10;

            x /= 10;
            y /= 10;
        }

        System.out.println(Math.max(a, b));
    }
}