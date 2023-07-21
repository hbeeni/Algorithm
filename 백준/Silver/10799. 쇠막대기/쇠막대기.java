import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int total = 0, answer = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                if (str.charAt(i + 1) == ')') {
                    answer += total;
                    i++;
                } else {
                    total++;
                }
            } else {
                answer++;
                total--;
            }
        }

        System.out.println(answer);
    }
}