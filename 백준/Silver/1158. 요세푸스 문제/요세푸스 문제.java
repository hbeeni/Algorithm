import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] remove = new boolean[n + 1];
        int[] result = new int[n];

        int count = k;
        int index = k;
        int resultIndex = 0;

        while (resultIndex < n) {
            while (true) {
                if (index == n + 1) {
                    index = 1;
                }
                if (count >= k && !remove[index]) {
                    break;
                }
                
                if (!remove[index]) {
                    count++;
                    index++;
                } else {
                    index++;
                }
            }

            remove[index] = true;
            result[resultIndex++] = index++;
            count = 1;
        }

        bw.write("<");
        for (int i = 0; i < n - 1; i++) {
            bw.write(result[i] + ", ");
        }
        bw.write(result[n - 1] + ">");

        bw.flush();
    }
}