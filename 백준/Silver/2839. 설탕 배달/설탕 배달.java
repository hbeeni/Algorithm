import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        while (n > 0 && n % 5 != 0) {
            n -= 3;
            result++;
        }

        if (n < 0) {
            System.out.println(-1);
        } else {
            result += n / 5;
            System.out.println(result);
        }
    }
}