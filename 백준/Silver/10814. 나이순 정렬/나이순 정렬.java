import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(i, new String[]{st.nextToken(), st.nextToken()});
        }

        List<Entry<Integer, String[]>> list = map.entrySet().stream()
                .sorted(Comparator.comparingInt((Entry<Integer, String[]> o) -> Integer.parseInt(o.getValue()[0]))
                        .thenComparingInt(Entry::getKey))
                .collect(Collectors.toList());

        list.forEach(e -> sb.append(e.getValue()[0]).append(" ").append(e.getValue()[1]).append("\n"));
        System.out.println(sb);
    }
}