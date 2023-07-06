import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            bw.write(" ".repeat(n - 1 - i));
            bw.write("*".repeat(2 * i + 1));
            bw.newLine();
        }

        for (int i = n - 2; i >= 0; i--) {
            bw.write(" ".repeat(n - 1 - i));
            bw.write("*".repeat(2 * i + 1));
            bw.newLine();
        }

        bw.flush();
    }
}