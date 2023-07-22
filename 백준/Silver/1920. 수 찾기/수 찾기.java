import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int searchNum = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = n - 1;

            while (true) {
                int mid = (s + e) / 2;

                if (searchNum == a[mid]) {
                    bw.write("1");
                    break;
                } else if (searchNum < a[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }

                if (s > e) {
                    bw.write("0");
                    break;
                }
            }

            bw.write("\n");
        }

        bw.flush();
    }
}
