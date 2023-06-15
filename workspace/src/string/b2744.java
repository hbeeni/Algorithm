package string;

import java.util.Scanner;

public class b2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] -= 32;
            } else {
                chars[i] += 32;
            }
        }

        System.out.println(chars);
    }
}
