import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 3; i++) {
                a[i] = Integer.parseInt(st.nextToken()); 
            }

            if (a[0] == 0) {
                break;
            }

            Arrays.sort(a);

            if (a[0] + a[1] <= a[2]) {
                System.out.println("Invalid");
            } else if (a[0] == a[1] && a[1] == a[2]) {
                System.out.println("Equilateral");
            } else if (a[0] != a[1] && a[1] != a[2] && a[0] != a[2]) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}