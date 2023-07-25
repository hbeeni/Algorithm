import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] count = new int['z' - 'a' + 1];
        Arrays.fill(count, -1);

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';

            if (count[index] == -1) {
                count[index] = i;
            }
        }

        for (int i : count) {
            System.out.print(i + " ");
        }
    }
}