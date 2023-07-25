import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch + 13 > 'z') {
                    sb.append((char) ('a' + ch + 12 - 'z'));
                } else {
                    sb.append((char) (ch + 13));
                }
            } else if (ch >= 'A' && ch <= 'Z') {
                if (ch + 13 > 'Z') {
                    sb.append((char) ('A' + ch + 12 - 'Z'));
                } else {
                    sb.append((char) (ch + 13));
                }
            } else {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}