import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            int lower = 0, upper = 0, number = 0, space = 0;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == ' ') {
                    space++;
                } else if (ch >= '0' && ch <= '9') {
                    number++;
                } else if (ch >= 'a' && ch <= 'z') {
                    lower++;
                } else {
                    upper++;
                }
            }

            sb.append(lower + " ").append(upper + " ").append(number + " ").append(space + "\n");
        }

        System.out.println(sb);
    }
}