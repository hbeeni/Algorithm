package selection;

import java.util.Scanner;

public class B1427_s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] a = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i) - '0';
        }

        //선택 정렬
        for (int i = 0; i < str.length(); i++) {
            int max = i;

            for (int j = i + 1; j < str.length(); j++) {
                if (a[j] > a[max]) {
                    max = j;
                }
            }

            if (a[i] < a[max]) {
                int tmp = a[i];
                a[i] = a[max];
                a[max] = tmp;
            }
        }

        for (int num : a) {
            System.out.print(num);
        }
    }
}
