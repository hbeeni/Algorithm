import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int plus = sc.nextInt();

        h += plus / 60;
        m += plus % 60;

        if (m > 59) {
            m -= 60;
            h += 1;
        }
        
        if (h > 23) {
            h %= 24;
        }

        System.out.println(h + " " + m);
    }
}
