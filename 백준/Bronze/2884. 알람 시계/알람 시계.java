import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[2];
        a[0] = sc.nextInt();
        a[1] = sc.nextInt();

        a[1] -= 45;
        if (a[1] < 0) {
            a[1] = a[1] + 60;
            a[0] -= 1;

            if (a[0] < 0) {
                a[0] = 23;
            }
        }

        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    }
}
