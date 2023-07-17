import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine().split(" ")[0];

            if (!set.contains(name)) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        TreeSet<String> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(set);

        StringBuilder sb = new StringBuilder();
        sortedSet.forEach(name -> sb.append(name).append("\n"));
        System.out.println(sb);
    }
}