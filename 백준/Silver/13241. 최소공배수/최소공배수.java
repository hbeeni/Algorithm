import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        long tmpA = a;
        long tmpB = b;

        while (tmpB != 0) {
            long r = tmpA % tmpB;

            tmpA = tmpB;
            tmpB = r;
        }

        System.out.println(a * b / tmpA);
    }
}