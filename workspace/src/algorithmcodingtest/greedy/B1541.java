package algorithmcodingtest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        boolean minus = false;
        int num = 0;
        int sum = 0;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (minus) {
                sum -= num;
                num = 0;
             } else {
                sum += num;
                num = 0;

                if (ch == '-') {
                    minus = true;
                }
            }
        }

        if (minus) {
            sum -= num;
        } else {
            sum += num;
        }

        System.out.println(sum);
    }
}
