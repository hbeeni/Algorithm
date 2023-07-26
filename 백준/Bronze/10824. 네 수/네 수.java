import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        long num1 = Long.parseLong(a[0] + a[1]);
        long num2 = Long.parseLong(a[2] + a[3]);

        System.out.println(num1 + num2);
    }
}