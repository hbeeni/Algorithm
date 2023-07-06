import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isSame = false;
        int same = 0;
        int[] n = new int[3];

        for (int i = 0; i < 3; i++) {
            n[i] = sc.nextInt();
        }
        Arrays.sort(n);

        for (int i = 1; i < 3; i++) {
            if (n[i - 1] == n[i]) {
                isSame = true;
                same = n[i];
                break;
            }
        }

        if (n[0] == n[2]) {
            System.out.println(10000 + n[0] * 1000);
        } else if (isSame) {
            System.out.println(1000 + same * 100);
        } else {
            System.out.println(n[2] * 100);
        }
    }
}
