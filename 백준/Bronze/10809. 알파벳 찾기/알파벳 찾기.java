import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] index = new int[26];

        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 'a';

            if (index[n] == -1) {
                index[n] = i;
            }
        }

        for (int i : index) {
            System.out.print(i + " ");
        }
    }
}