import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mod = 1_000_000_007;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int tmp = 1;
        while (Math.pow(2, tmp) < n) {
            tmp++;
        }

        int start = (int) Math.pow(2, tmp);
        int size = start * 2;
        long[] tree = new long[size];

        Arrays.fill(tree, 1);
        for (int i = 0; i < n; i++) {
            tree[start + i] = Integer.parseInt(br.readLine());
        }
        for (int i = start - 1; i > 0; i--) {
            tree[i] = (tree[2 * i] * tree[2 * i + 1]) % mod;
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                int index = Integer.parseInt(st.nextToken()) + start - 1;
                int value = Integer.parseInt(st.nextToken());
                tree[index] = value;
                while ((index /= 2) > 0) {
                    tree[index] = (tree[2 * index] * tree[2 * index + 1]) % mod;
                }
            } else {
                int s = Integer.parseInt(st.nextToken()) + start - 1;
                int e = Integer.parseInt(st.nextToken()) + start - 1;
                long answer = 1;
                while (s <= e) {
                    if (s % 2 == 1) {
                        answer = answer * tree[s] % mod;
                    }
                    if (e % 2 == 0) {
                        answer = answer * tree[e] % mod;
                    }
                    s = (s + 1) / 2;
                    e = (e - 1) / 2;
                }
                System.out.println(answer % mod);
            }
        }
    }
}
