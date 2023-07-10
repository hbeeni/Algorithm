import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = sc.nextInt();
        int[] unit = {25, 10, 5, 1};

        for (int i = 0; i < t; i++) {
            int money = sc.nextInt();

            for (int j = 0; j < unit.length; j++) {
                bw.write((money / unit[j]) + " ");
                money %= unit[j];
            }

            bw.newLine();
        }

        bw.flush();
    }
}