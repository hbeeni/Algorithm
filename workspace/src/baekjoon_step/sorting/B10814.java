//https://infodon.tistory.com/52

package baekjoon_step.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[][] a = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = st.nextToken();
            a[i][1] = st.nextToken();
        }

        Arrays.sort(a, (s1, s2) -> {
            if (s1[0].equals(s2[0])) {
                return 1;
            } else {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        for (String[] judge : a) {
            sb.append(judge[0]).append(" ").append(judge[1]).append("\n");
        }
        System.out.println(sb);
    }
}
