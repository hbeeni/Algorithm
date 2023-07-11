import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            List<Integer> divisors = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                }
            }

            int sum = 0;
            for (Integer divisor : divisors) {
                sum += divisor;
            }

            StringBuffer sb = new StringBuffer();
            if (sum == n) {
                sb = sb.append(n + " = ");

                for (int i = 0; i < divisors.size() - 1; i++) {
                    sb = sb.append(divisors.get(i) + " + ");
                }

                sb.append(divisors.get(divisors.size() - 1));
            } else {
                sb.append(n + " is NOT perfect.");
            }

            System.out.println(sb);
        }
    }
}