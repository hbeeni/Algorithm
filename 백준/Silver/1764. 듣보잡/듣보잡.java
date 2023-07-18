import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> notHear = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notHear.add(br.readLine());
        }

        TreeSet<String> sortedSet = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();

            if (notHear.contains(name)) {
                sortedSet.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sortedSet.size()).append("\n");
        sortedSet.forEach(name -> sb.append(name).append("\n"));

        System.out.println(sb);
    }
}