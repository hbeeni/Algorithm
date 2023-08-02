import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            n = 2;
        } else if (n % 2 == 0){
            n++;
        }

        while (true) {
            String str = String.valueOf(n);
            String reverseStr = new StringBuilder(str).reverse().toString();
            boolean isPrime = true;

            if (str.equals(reverseStr)) {
                for (int i = 3; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    break;
                }
            }

            n += 2;
        }

        System.out.println(n);
    }
}
