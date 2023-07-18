import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] words = br.readLine().split(" ");

            for (int j = 0; j < words.length; j++) {
                for (int k = words[j].length() - 1; k >= 0; k--) {
                    sb.append(words[j].charAt(k));
                }

                sb.append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}