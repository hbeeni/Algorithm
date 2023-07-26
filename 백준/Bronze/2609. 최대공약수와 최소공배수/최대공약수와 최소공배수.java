import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int a = num1, b = num2;

        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }

        System.out.println(a);
        System.out.println(num1 * num2 / a);
    }
}