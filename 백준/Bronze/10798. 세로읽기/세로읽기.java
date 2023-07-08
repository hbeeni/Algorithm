import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = new String[5];
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < 5; i++) {
            a[i] = br.readLine();
        }

        for (int i = 0; i < 15; i++) {
            boolean end = true;
            for (int j = 0; j < 5; j++) {
                if (i < a[j].length()) {
                    result.append(a[j].charAt(i));
                    end = false;
                }
            }

            if (end) {
                break;
            }
        }

        System.out.println(result);
    }
}