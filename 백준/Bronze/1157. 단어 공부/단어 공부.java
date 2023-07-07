import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase();
        int[] a = new int['z' - 'a' + 1];

        for (int i = 0; i < word.length(); i++) {
            a[word.charAt(i) - 'A']++;
        }

        boolean multiple = false;
        int index = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                continue;
            }
            if (max == a[i]) {
                multiple = true;
                continue;
            }
            if (max < a[i]) {
                multiple = false;
                max = a[i];
                index = i;
            }
        }

        if (max == 0 || multiple) {
            System.out.println("?");
        } else {
            System.out.println((char) ('A' + index));
        }
    }
}