package algorithmcodingtest.sorting.selection;

import java.util.Arrays;
import java.util.Scanner;

public class B1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();
        int[] a = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i) - '0';
        }

        Arrays.sort(a);

        for (int i = a.length - 1; i >= 0; i--) {
            sb.append(a[i]);
        }

        System.out.println(sb);
    }
}
