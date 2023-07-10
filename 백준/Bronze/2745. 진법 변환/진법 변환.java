import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int b = sc.nextInt();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(str.length() - i - 1);
            int n;
            
            if (ch >= '0' && ch <= '9') {
                n = ch - '0';
            } else {
                n = ch - 'A' + 10;
            }

            result += n * Math.pow(b, i);
        }

        System.out.println(result);
    }
}