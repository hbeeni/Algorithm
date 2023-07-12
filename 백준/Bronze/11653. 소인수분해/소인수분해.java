import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        while (true) {
            boolean end = true;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    sb.append(i + "\n");
                    n /= i;
                    end = false;
                    break;
                }
            }

            if (end) {
                sb.append(n);
                break;
            }
        }

        if (n != 1) {
            System.out.println(sb);
        }
    }
}