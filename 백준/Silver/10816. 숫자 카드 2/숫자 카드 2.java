import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(count.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }

        System.out.println(sb);
    }
}