import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] a = new String[input.length()];
        a[0] = input;

        for (int i = 1; i < input.length(); i++) {
            a[i] = input.substring(i);
        }

        Arrays.sort(a);

        for (String s : a) {
            System.out.println(s);
        }
    }
}