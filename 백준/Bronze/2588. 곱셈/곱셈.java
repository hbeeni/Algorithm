import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int result = x * y;

        String tmp = String.valueOf(y);
        for (int i = 2; i >= 0; i--) {
            int n = tmp.charAt(i) - '0';
            System.out.println(x * n);
        }

        System.out.println(result);
    }
}
