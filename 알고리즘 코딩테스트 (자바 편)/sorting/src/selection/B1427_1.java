package selection;

import java.util.Scanner;

public class B1427_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] a = new int[10];

        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            System.out.print(String.valueOf(i).repeat(a[i]));
        }
    }
}
