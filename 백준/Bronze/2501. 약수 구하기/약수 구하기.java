import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k == 1) {
            System.out.println(1);
        } else {
            int count = 1;
            int num = 2;
            boolean find = false;

            for (; num <= n; num++) {
                if (n % num == 0) {
                    count++;
                }
                if (count == k) {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(num);
            } else {
                System.out.println(0);
            }
        }
    }
}