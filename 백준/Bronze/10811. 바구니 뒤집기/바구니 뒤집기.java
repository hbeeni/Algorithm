import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while (start < end) {
                int tmp = basket[start];
                basket[start] = basket[end];
                basket[end] = tmp;
                
                start++;
                end--;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}