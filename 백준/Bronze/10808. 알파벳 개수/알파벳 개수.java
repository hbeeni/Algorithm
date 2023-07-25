import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] count = new int['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) -'a']++;
        }

        for (int i : count) {
            System.out.print(i + " ");
        }
    }
}