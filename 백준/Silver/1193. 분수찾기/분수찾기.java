import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 1;
        int max = 1;

        while (n > max) {
            count++;
            max += count;
        }

        int num = n - (max - count + 1);

        if (count % 2 == 0) {
            System.out.println((1 + num) + "/" + (count - num));
        } else {
            System.out.println((count - num) + "/" + (1 + num));
        }
    }
}