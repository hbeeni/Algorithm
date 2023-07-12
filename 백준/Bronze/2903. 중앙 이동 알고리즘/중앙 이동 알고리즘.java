import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 2;
        for (int i = 1; i <= n; i++) {
            num += Math.pow(2, i - 1);
        }

        System.out.println(num * num);
    }
}