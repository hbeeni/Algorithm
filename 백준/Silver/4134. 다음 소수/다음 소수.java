import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num <= 2) {
                bw.write(2 + "\n");
                continue;
            }
            if (num % 2 == 0) {
                num++;
            }

            while (true) {
                boolean isPrime = true;

                for (int j = 3; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    bw.write(num + "\n");
                    break;
                }

                num += 2;
            }
        }

        bw.flush();
    }
}