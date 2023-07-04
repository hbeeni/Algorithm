import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;

        int s = 1;
        int e = 2;
        long sum = s + e;

        while (s < e) {
            if (sum == n) {
                count++;
                sum -= s;
                s++;
                e++;
                sum += e;
            } else if (sum < n) {
                e++;
                sum += e;
            } else {
                sum -= s;
                s++;
            }
        }

        if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(count);
        }
    }
}
