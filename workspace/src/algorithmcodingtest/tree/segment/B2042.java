package algorithmcodingtest.tree.segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //수의 개수
        int m = Integer.parseInt(st.nextToken()); //수의 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수
        
        int tmp = 0;
        while (Math.pow(2, tmp) < n) {
            tmp++;
        }

        int start = (int) Math.pow(2, tmp);
        long[] tree = new long[start * 2];
        for (int i = 0; i < n; i++) {
            tree[start + i] = Long.parseLong(br.readLine());
        }
        for (int i = start - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                int index = Integer.parseInt(st.nextToken()) + start - 1;
                long value = Long.parseLong(st.nextToken());
                long diff = value - tree[index];
                tree[index] = value;

                while ((index /= 2) > 0) {
                    tree[index] += diff;
                }
            } else {
                int s = Integer.parseInt(st.nextToken()) + start - 1;
                int e = Integer.parseInt(st.nextToken()) + start - 1;
                long sum = 0;

                while (s <= e) {
                    if (s % 2 == 1) {
                        sum += tree[s];
                    }
                    if (e % 2 == 0) {
                        sum += tree[e];
                    }

                    s = (s + 1) / 2;
                    e = (e - 1) / 2;
                }

                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }
}
