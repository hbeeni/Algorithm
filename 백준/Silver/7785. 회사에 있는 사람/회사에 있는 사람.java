import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeSet<String> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String name = br.readLine().split(" ")[0];

            if (!sortedSet.contains(name)) {
                sortedSet.add(name);
            } else {
                sortedSet.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sortedSet.forEach(name -> sb.append(name).append("\n"));
        System.out.println(sb);
    }
}