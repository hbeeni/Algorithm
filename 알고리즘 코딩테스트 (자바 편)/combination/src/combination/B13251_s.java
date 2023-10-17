package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13251_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[m];
        double[] probability = new double[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
        }

        int k = Integer.parseInt(br.readLine());
        double answer = 0.0;
        for (int i = 0; i < m; i++) {
            if (a[i] >= k) {
                probability[i] = 1.0;
                /**
                 * ex) 총 18개의 조약돌 중 2개를 뽑을 때 5개의 조약돌이 있는 색깔만 뽑을 확률
                 * 5/18 * 4/17
                 */
                for (int j = 0; j < k; j++) {
                    probability[i] *= (double) (a[i] - j) / (total - j);
                }
            }
            answer += probability[i];
        }

        System.out.println(answer);
    }
}
