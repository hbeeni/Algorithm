import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] numToStr = new String[n + 1];
        HashMap<String, Integer> strToNum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            numToStr[i + 1] = name;
            strToNum.put(name, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String q = br.readLine();

            if (q.charAt(0) >= '0' && q.charAt(0) <= '9') {
                sb.append(numToStr[Integer.parseInt(q)]);
            } else {
                sb.append(strToNum.get(q));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}