import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

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
